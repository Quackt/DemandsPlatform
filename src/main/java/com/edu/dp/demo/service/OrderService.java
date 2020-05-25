package com.edu.dp.demo.service;


import com.edu.dp.demo.entity.OrderInfo;
import com.edu.dp.demo.repository.OrderInfoRepository;
import com.edu.dp.demo.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.dp.demo.commons.Result;

import java.sql.SQLException;
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
    public Result addOrder(OrderVO orderVO) {
        Result result = new Result();
        OrderInfo order = new OrderInfo();
        try {
            order.setPublisherId(orderVO.getPublisherId());
            order.setDeadline(orderVO.getDeadline());
            order.setDescription(orderVO.getDescription());
            order.setPrice(orderVO.getPrice());
            order.setType(orderVO.getType());
            orderRepository.save(order);
        }catch (Exception e){
            result.setCode(500);
            result.setData(null);
            result.setMsg("添加失败" + e.getMessage());
            return result;
        }
        result.setCode(200);
        result.setData(null);
        result.setMsg("添加成功");
        return  result;
    }

    /**
     * 更新需求信息
     * @param orderVO 交互类
     */
    public Result updateMessage(OrderVO orderVO) {
        long id = orderVO.getOrderId();
        Result result = new Result();
        try {
            if (!orderVO.getDeadline().equals(0)) {
                orderRepository.updateDeadlineById(id, orderVO.getDeadline());
            }
            if (!orderVO.getDescription().equals("")) {
                orderRepository.updateDescriptionById(id, orderVO.getDescription());
            }
            if (!orderVO.getType().equals("")) {
                orderRepository.updateTypeById(id, orderVO.getType());
            }
            if (orderVO.getPrice() != 0) {
                orderRepository.updatePriceById(id, orderVO.getPrice());
            }
        }catch (Exception e){
            result.setCode(500);
            result.setData(null);
            result.setMsg("更新失败" + e.getMessage());
            return result;
        }
        result.setCode(200);
        result.setData(null);
        result.setMsg("更新成功");
        return result;

    }

    /**
     * 添加评价
     * @param orderVO 交互类
     */
    public Result addComment(OrderVO orderVO) {
        String comment = orderVO.getComment();
        Result result = new Result();
        int stars = orderVO.getStars();
        try {
            orderRepository.updateCommentAndStarsById(comment,stars,orderVO.getOrderId());
        }catch (Exception e){
            result.setCode(500);
            result.setData(null);
            result.setMsg("添加失败" + e.getMessage());
            return result;
        }
        result.setCode(200);
        result.setData(null);
        result.setMsg("添加成功");
        return result;
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
    public Result deleteOrders(List<Long> ids){
        Result result = new Result();
        try{
            orderRepository.deleteByIds(ids);
        }catch (Exception e){
            result.setCode(500);
            result.setData(null);
            result.setMsg("删除失败" + e.getMessage());
            return result;
        }
        result.setCode(200);
        result.setData(null);
        result.setMsg("删除成功");
        return result;

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
    public Result takeOrder(long id,long orderId) {
        Result result = new Result();
        try {
            orderRepository.updateAccepterIdAndStatusById(orderId, id, OrderInfo.Status.PROCESSING);
        }catch (Exception e){
            result.setCode(500);
            result.setData(null);
            result.setMsg("接受失败" + e.getMessage());
            return result;
        }
        result.setCode(200);
        result.setData(null);
        result.setMsg("接受成功" + "订单号" + orderId);
        return result;
    }

    /**
     * 完成一个需求
     * @param id orderId
     */
    public Result finishOrder(long id) {
        Result result = new Result();
        try {
            orderRepository.updateStatusById(id, OrderInfo.Status.CANCLED);
        }catch (Exception e){
            result.setCode(500);
            result.setData(null);
            result.setMsg("订单无法完成" + e.getMessage());
            return result;
        }
        result.setCode(200);
        result.setData(null);
        result.setMsg("订单:"+id+"已完成！");
        return result;
    }
}
