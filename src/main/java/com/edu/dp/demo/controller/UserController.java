package com.edu.dp.demo.controller;

import com.edu.dp.demo.entity.User;
import com.edu.dp.demo.commons.Result;
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
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/addUser")
    public Result addUser(@RequestBody UserVO userVO){
        return userService.addUser(userVO);
    };

    @PostMapping(value = "/updateInfo")
    public Result updateUserInfo(@RequestBody UserVO userVO){

        return userService.updateUserInfo(userVO);
    }

    @PostMapping("/delete")
    public Result deleteUsers(@RequestBody List<Long> ids){

        return userService.deleteUser(ids);
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
