package com.edu.dp.demo.vo;

import com.edu.dp.demo.entity.User;
/**
 * @program DemandsPlatform
 * @description 用户信息交互类
 * @date 2020/05/13
 */
public class UserVO {
    private String name;

    private User.Sex sex;

    private String schoolCardId;

    private String email;

    private  String phone;

    private String password;

    public UserVO(){};

    public UserVO(String name, User.Sex sex, String schoolCardId, String email, String phone, String password) {
        this.name = name;
        this.sex = sex;
        this.schoolCardId = schoolCardId;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User.Sex getSex() {
        return sex;
    }

    public void setSex(User.Sex sex) {
        this.sex = sex;
    }

    public String getSchoolCardId() {
        return schoolCardId;
    }

    public void setSchoolCardId(String schoolCardId) {
        this.schoolCardId = schoolCardId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
