package com.edu.dp.demo.component;

import com.edu.dp.demo.entity.OrderInfo;
import com.edu.dp.demo.repository.OrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author ASUS
 */
@Component
public class OrderControlComponent {
    private static OrderInfoUnit orderInfoUnit = new OrderInfoUnit();
    @Autowired
    OrderInfoRepository orderRepository;

    public static void add(OrderInfo orderInfo){
        OrderInfoUnit orderInfoUnit = OrderControlComponent.orderInfoUnit;
        OrderInfoUnit newOrderInfoUnit = new OrderInfoUnit();
        newOrderInfoUnit.setOrderInfo(orderInfo);
        if(orderInfoUnit.getOrderInfo().equals(null)){
            orderInfoUnit.setOrderInfo(orderInfo);
            return;
        }
        if(orderInfoUnit.getOrderInfo().getDeadline().after(orderInfo.getDeadline())){
            newOrderInfoUnit.setNext(orderInfoUnit);
            OrderControlComponent.orderInfoUnit=newOrderInfoUnit;
            return;
        }
        while(true){
            if(orderInfoUnit.getNext()==null){
                orderInfoUnit.setNext(newOrderInfoUnit);
                return;
            }
            if(!orderInfo.getDeadline().after(orderInfoUnit.getNext().getOrderInfo().getDeadline())){
                newOrderInfoUnit.setNext(orderInfoUnit.getNext());
                orderInfoUnit.setNext(newOrderInfoUnit);
                return;
            }
            orderInfoUnit = orderInfoUnit.getNext();
        }
    }

    @Scheduled(fixedRate=30000)
    public void cancleOrdersByTime(){
        Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
        if(orderInfoUnit.getOrderInfo().equals(null)||orderInfoUnit.getOrderInfo().getDeadline().after(timestamp)){
            return;
        }
        OrderInfoUnit orderInfoUnit = OrderControlComponent.orderInfoUnit;
        while(true){
            if(orderInfoUnit.getOrderInfo().getDeadline().after(timestamp)){
                return;
            }
            orderRepository.updateStatusById(orderInfoUnit.getOrderInfo().getOrderId(),OrderInfo.Status.CANCLED);
            if(orderInfoUnit.getNext().equals(null)){
                return;
            }
            orderInfoUnit = orderInfoUnit.getNext();
        }
    }
}

class OrderInfoUnit {
    private OrderInfo orderInfo;
    private OrderInfoUnit next;

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public OrderInfoUnit getNext() {
        return next;
    }

    public void setNext(OrderInfoUnit next) {
        this.next = next;
    }
}

