package com.rcy.springbootmybatisannotation.controller;

import com.rcy.springbootmybatisannotation.bean.UserEntity;
import com.rcy.springbootmybatisannotation.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: rencaiyu 2019年12月30日 15:16
 **/
@Controller
@RequestMapping("/user")
@RestController
public class UserComtroller {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/userQuery")
    public List<UserEntity> queryUserList(){
        List<UserEntity> userList = userMapper.getUserList();
        return userList;
    }
}
