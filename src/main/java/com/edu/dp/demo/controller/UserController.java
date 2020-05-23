package com.edu.dp.demo.controller;

import com.edu.dp.demo.entity.User;
import com.edu.dp.demo.service.UserService;
import com.edu.dp.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program DemandsPlatform
 * @description 用户管理服务器
 * @date 2020/05/13
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/orders")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/addUser")
    public void addUser(@RequestBody UserVO userVO){
        userService.addUser(userVO);
    };

    @PostMapping(value = "/updateInfo")
    public void updateUserInfo(@RequestBody UserVO userVO){
        userService.updateUserInfo(userVO);
    }

    @DeleteMapping("/delete")
    public void deleteUsers(@RequestParam(name="schoolCardIds[]") List<Long> ids){
        userService.deleteUser(ids);
    }

    @PostMapping("/query")
    public List<User> quertUsers(@RequestBody UserVO userVO){
        return userService.queryUsers(userVO);
    }

    @GetMapping("/getAllUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
