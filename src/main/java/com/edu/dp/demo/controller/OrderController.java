package com.edu.dp.demo.controller;


import com.edu.dp.demo.entity.OrderInfo;
import com.edu.dp.demo.service.OrderService;
import com.edu.dp.demo.vo.OrderVO;
import com.edu.dp.demo.commons.Result;
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
@RequestMapping(value="/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody OrderVO orderVO) {
        return orderService.addOrder(orderVO);
    }

    @PostMapping("/deleteOrders")
    public Result deleteOrders(@RequestBody List<Long> ids){
        return orderService.deleteOrders(ids);
    }

    @PostMapping("/updateMessage")
    public Result updateMessage(@RequestBody OrderVO orderVO){
       return orderService.updateMessage(orderVO);
    }

    @PostMapping("/addComment")
    public Result addComment(@RequestBody OrderVO orderVO){
        return orderService.addComment(orderVO);
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
    public Result takeOrder(@RequestParam(value="accepterId") long id,@RequestParam(value = "orderId")long orderId){
        return orderService.takeOrder(id,orderId);
    }

    @PutMapping("/finish")
    public Result fihishOrder(@RequestParam(value="orderId") long id){return orderService.finishOrder(id);}

    @PutMapping("/cancle")
    public Result cancleOrder(@RequestParam(value="orderId") long id){return orderService.finishOrder(id);}
}
