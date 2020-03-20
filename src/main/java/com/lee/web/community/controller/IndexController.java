package com.lee.web.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Company MySteelSoft
 * @Author GaoYang Lee
 * @Date Create in 2020/3/18 15:19
 * @Description This is a good day
 **/
@Controller("/user")
public class IndexController {

    @GetMapping("/index")
    public String hello(){
        return "index";
    }

}
