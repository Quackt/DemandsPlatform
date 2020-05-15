package com.edu.dp.demo.vo;

import com.edu.dp.demo.entity.OrderInfo;

import java.sql.Timestamp;
/**
 * @program DemandsPlatform
 * @description 订单信息交互类
 * @date 2020/05/13
 */
public class OrderVO {
    private long orderId;

    private long publisherId;

    private long accepterId;

    private Timestamp deadline;

    private String description;

    private String comment;

    private int stars;

    private OrderInfo.Status status;

    public OrderVO(){};

    public OrderVO(long orderId, long publisherId, Timestamp deadline, String description, String comment, int stars,OrderInfo.Status status) {
        this.orderId = orderId;
        this.publisherId = publisherId;
        this.deadline = deadline;
        this.description = description;
        this.comment = comment;
        this.stars = stars;
        this.status = status;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public OrderInfo.Status getStatus() {
        return status;
    }

    public void setStatus(OrderInfo.Status status) {
        this.status = status;
    }
}
