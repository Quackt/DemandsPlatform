package com.edu.dp.demo.service;

import com.edu.dp.demo.entity.User;
import com.edu.dp.demo.repository.UserRepository;
import com.edu.dp.demo.vo.UserVO;
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
    public void addUser(UserVO userVO) {
        User user = new User();
        user.setName(userVO.getName());
        user.setEmailAddress(userVO.getEmail());
        user.setPhone(userVO.getPhone());
        user.setSchoolCardId(Long.parseLong(userVO.getSchoolCardId()));
        user.setSex(userVO.getSex());
        user.setPassword(userVO.getPassword());
        userRepository.save(user);
    }

    /**
     * 更新用户信息
     * @param userVO 用户交互类
     */
    public void updateUserInfo(UserVO userVO) {
        long id = Long.parseLong(userVO.getSchoolCardId());
        if(!userVO.getEmail().equals("")){
            userRepository.updateEmailById(id,userVO.getEmail());
        }
        if(!userVO.getName().equals("")){
            userRepository.updateNameById(id,userVO.getName());
        }
        if(!userVO.getSex().equals("unknown")){
            userRepository.updateSexById(id,userVO.getSex());
        }
        if(!userVO.getPassword().equals("")){
            userRepository.updatePasswordById(id,userVO.getPassword());
        }
        if(!userVO.getPhone().equals("")){
            userRepository.updatePhoneById(id,userVO.getPhone());
        }
    }

    /**
     * 删除一个用户
     * @param ids 被删除的一组用户id
     */
    public void deleteUser(List<Long> ids) {
        userRepository.deleteByIds(ids);
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
