package com.lee.web.community.mapper;

import com.lee.web.community.model.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @Company MySteelSoft
 * @Author GaoYang Lee
 * @Date Create in 2020/3/23 11:21
 * @Description This is a good day
 **/
public interface UserMapper {

   int insertUser(User user);

   User findUserByToken(String token);

}
