package com.edu.dp.demo.service;


import com.edu.dp.demo.entity.OrderInfo;
import com.edu.dp.demo.repository.OrderInfoRepository;
import com.edu.dp.demo.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @program DemandsPlatform
 * @description 需求管理服务层
 * @date 2020/05/13
 */
@Service
public class OrderService {
    @Autowired
    OrderInfoRepository orderRepository;

    /**
     * 添加一个需求
     * @param orderVO 交互类
     */
    public void addOrder(OrderVO orderVO) {
        OrderInfo order = new OrderInfo();
        order.setPublisherId(orderVO.getPublisherId());
        order.setDeadline(orderVO.getDeadline());
        order.setDescription(orderVO.getDescription());
        order.setPrice(orderVO.getPrice());
        order.setType(orderVO.getType());
        orderRepository.save(order);

    }

    /**
     * 更新需求信息
     * @param orderVO 交互类
     */
    public void updateMessage(OrderVO orderVO) {
        long id = orderVO.getOrderId();
        if(!orderVO.getDeadline().equals(0)){
            orderRepository.updateDeadlineById(id,orderVO.getDeadline());
        }
        if(!orderVO.getDescription().equals("")){
            orderRepository.updateDescriptionById(id,orderVO.getDescription());
        }
        if(!orderVO.getType().equals("")){
            orderRepository.updateTypeById(id,orderVO.getType());
        }
        if(orderVO.getPrice()!=0){
            orderRepository.updatePriceById(id,orderVO.getPrice());
        }
    }

    /**
     * 添加评价
     * @param orderVO 交互类
     */
    public void addComment(OrderVO orderVO) {
        String comment = orderVO.getComment();
        int stars = orderVO.getStars();
        orderRepository.updateCommentAndStarsById(comment,stars,orderVO.getOrderId());
    }

    /**
     * 查询需求信息
     * @param orderVO 交互类
     * @return List 需求表
     */
    public List<OrderInfo> queryOrders(OrderVO orderVO) {
        if(!orderVO.getDeadline().equals(0)){
            return orderRepository.findByDeadline(orderVO.getDeadline());
        }else if(orderVO.getStars()!=0){
            return orderRepository.findByStars(orderVO.getStars());
        }else if(orderVO.getPublisherId()!=0){
            return orderRepository.findByPublisherId(orderVO.getPublisherId());
        }else if(orderVO.getStatus().equals(null)){
            return orderRepository.findByStatus(orderVO.getStatus());
        }
        return null;
    }

    /**
     * 删除需求信息
     * @param ids 要删除的id列表
     */
    public void deleteOrders(List<Long> ids){
        orderRepository.deleteByIds(ids);
    }

    /**
     * 返回所有需求信息
     * @return List 需求表
     */
    public List<OrderInfo> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * 接受一个需求
     * @param id 接收者id
     *         orderId 需求id
     */
    public void takeOrder(long id,long orderId) {
        orderRepository.updateAccepterIdAndStatusById(orderId,id,OrderInfo.Status.PROCESSING);
    }

    /**
     * 完成一个需求
     * @param id orderId
     */
    public void finishOrder(long id) {
        orderRepository.updateStatusById(id,OrderInfo.Status.CANCLED);
    }
}
