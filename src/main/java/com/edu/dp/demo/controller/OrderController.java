package com.edu.dp.demo.controller;


import com.edu.dp.demo.entity.OrderInfo;
import com.edu.dp.demo.service.OrderService;
import com.edu.dp.demo.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program DemandsPlatform
 * @description 需求管理服务器
 * @date 2020/05/13
 */
@RestController
@CrossOrigin
@RequestMapping(value="/users")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public void addOrder(@RequestBody OrderVO orderVO) {
        orderService.addOrder(orderVO);
    }

    @DeleteMapping("/deleteOrders")
    public void deleteOrders(@RequestParam(value="ids[]") List<Long> ids){
        orderService.deleteOrders(ids);
    }

    @PostMapping("/updateMessage")
    public void updateMessage(@RequestBody OrderVO orderVO){
        orderService.updateMessage(orderVO);
    }

    @PostMapping("/addComment")
    public void addComment(@RequestBody OrderVO orderVO){
        orderService.addComment(orderVO);
    }

    @PostMapping("/query")
    public List<OrderInfo> queryOrders(@RequestBody OrderVO orderVO){
        return orderService.queryOrders(orderVO);
    }

    @GetMapping("/getAllOrders")
    public List<OrderInfo> getAllOrders(){
       return orderService.getAllOrders();
    }

    @PutMapping("/accept")
    public void takeOrder(@RequestParam(value="accepterId") long id,@RequestParam(value = "orderId")long orderId){
        orderService.takeOrder(id,orderId);
    }

    @PutMapping("/finish")
    public void fihishOrder(@RequestParam(value="orderId") long id){orderService.finishOrder(id);}

    @PutMapping("/cancle")
    public void cancleOrder(@RequestParam(value="orderId") long id){orderService.finishOrder(id);}
}
