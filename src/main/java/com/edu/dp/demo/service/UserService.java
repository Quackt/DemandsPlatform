package com.edu.dp.demo.service;

import com.edu.dp.demo.entity.User;
import com.edu.dp.demo.repository.UserRepository;
import com.edu.dp.demo.vo.UserVO;
import com.edu.dp.demo.commons.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @program DemandsPlatform
 * @description 用户管理服务器
 * @date 2020/05/13
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * 添加一个用户
     * @param userVO 用户交互类
     */
    public Result addUser(UserVO userVO) {
        Result result = new Result();
        User user = new User();
        user.setName(userVO.getName());
        user.setEmailAddress(userVO.getEmail());
        user.setPhone(userVO.getPhone());
        user.setSchoolCardId(Long.parseLong(userVO.getSchoolCardId()));
        user.setSex(userVO.getSex());
        user.setPassword(userVO.getPassword());
        try {
            userRepository.save(user);
        }catch (Exception e){
            result.setCode(500);
            result.setData(null);
            result.setMsg("添加失败"+e.getMessage());
            return result;
        }
        result.setCode(200);
        result.setData(null);
        result.setMsg("添加成功");
        return result;
    }

    /**
     * 更新用户信息
     * @param userVO 用户交互类
     */
    public Result updateUserInfo(UserVO userVO) {
        Result result = new Result();
        long id = Long.parseLong(userVO.getSchoolCardId());
        try {
            if (!userVO.getEmail().equals("")) {
                userRepository.updateEmailById(id, userVO.getEmail());
            }
            if (!userVO.getName().equals("")) {
                userRepository.updateNameById(id, userVO.getName());
            }
            if (!userVO.getSex().equals("unknown")) {
                userRepository.updateSexById(id, userVO.getSex());
            }
            if (!userVO.getPassword().equals("")) {
                userRepository.updatePasswordById(id, userVO.getPassword());
            }
            if (!userVO.getPhone().equals("")) {
                userRepository.updatePhoneById(id, userVO.getPhone());
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
     * 删除一个用户
     * @param ids 被删除的一组用户id
     */
    public Result deleteUser(List<Long> ids) {
        Result result = new Result();
        try {
            userRepository.deleteByIds(ids);
        }catch (Exception e){
            result.setCode(500);
            result.setData(null);
            result.setMsg("删除失败"+e.getMessage());
            return result;
        }
        result.setCode(200);
        result.setData(null);
        result.setMsg("删除成功");
        return result;
    }

    /**
     * 查询用户
     * @param userVO 用户交互类
     * @return list 用户信息表
     */
    public List<User> queryUsers(UserVO userVO) {
        if(!userVO.getEmail().equals("")){
            return userRepository.findByEmail(userVO.getEmail());
        }
        if(!userVO.getName().equals("")){
            return userRepository.findByName(userVO.getName());
        }

        if(!userVO.getPhone().equals("")){
            return userRepository.findByPhone(userVO.getPhone());
        }
        if(!userVO.getSchoolCardId().equals("")){
            long id = Long.parseLong(userVO.getSchoolCardId());
            return userRepository.findBySchoolCardId(id);
        }
        if(!userVO.getSex().equals("unknown")){
            return userRepository.findBySex(userVO.getSex());
        }
        return null;
    }

    /**
     * 获取所有用户
     * @return list 用户信息表
     */
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
