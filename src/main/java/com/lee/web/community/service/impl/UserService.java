package com.lee.web.community.service.impl;

import com.lee.web.community.mapper.UserMapper;
import com.lee.web.community.model.User;
import com.lee.web.community.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Company MySteelSoft
 * @Author GaoYang Lee
 * @Date Create in 2020/3/23 13:22
 * @Description This is a good day
 **/
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        int i = userMapper.insertUser(user);
    }

    @Override
    public User findUserByToken(String token) {
        return userMapper.findUserByToken(token);

    }
}

