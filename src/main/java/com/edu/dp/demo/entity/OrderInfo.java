package com.edu.dp.demo.entity;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @program DemandsPlatform
 * @description 订单类
 * @date 2020/05/13
 */
@Entity
@Table
public class OrderInfo {
    public enum Status {FINISHED,UNFINISHED,CANCLED,WANTED,PROCESSING};
    @Id
    private long orderId;

    @Column
    private Timestamp date;

    @Column
    private long publisherId;

    @Column
    private long accepterId;

    @Column
    private Timestamp deadline;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private String comment;

    @Column
    private String description;

    @Column
    private int stars;

    public OrderInfo(){
        this.date = new Timestamp(new java.util.Date().getTime());
    };

    public OrderInfo(long publisherId, long accepterId, Timestamp deadline) {
        this.date = new Timestamp(new java.util.Date().getTime());
        this.publisherId = publisherId;
        this.accepterId = accepterId;
        this.deadline = deadline;
        this.status = Status.WANTED;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public long getAccepterId() {
        return accepterId;
    }

    public void setAccepterId(long accepterId) {
        this.accepterId = accepterId;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
