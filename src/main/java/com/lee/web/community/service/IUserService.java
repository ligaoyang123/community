package com.lee.web.community.service;

import com.lee.web.community.model.User;

/**
 * @Company MySteelSoft
 * @Author GaoYang Lee
 * @Date Create in 2020/3/23 13:22
 * @Description This is a good day
 **/
public interface IUserService {

    public void insertUser(User user);

    public User findUserByToken(String token);
}
