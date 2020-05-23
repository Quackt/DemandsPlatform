package com.edu.dp.demo.entity;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * @program DemandsPlatform
 * @description 用户类
 * @date 2020/05/13
 */

@Entity
@Table
public class User {
    public static enum Sex {MALE,FEMALE};
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column
    private String schoolCardId;

    @Column
    private String email;

    @Column
    private  String phone;

    @Column
    private java.sql.Date date;

    @Column
    private String password;

    public User(){}

    public User(String name, Sex sex, String schoolCardId, String email, String phone, String password) {
        this.name = name;
        this.sex = sex;
        this.schoolCardId = schoolCardId;
        this.email = email;
        this.phone = phone;
        java.util.Date utilDate = new java.util.Date();
        this.date = new java.sql.Date(utilDate.getTime());
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getSchoolCardId() {
        return schoolCardId;
    }

    public void setSchoolCardId(String schoolCardId) {
        this.schoolCardId = schoolCardId;
    }

    public String getEmailAddress() {
        return email;
    }

    public void setEmailAddress(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
