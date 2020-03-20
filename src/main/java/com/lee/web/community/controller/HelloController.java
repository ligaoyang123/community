package com.lee.web.community.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Company MySteelSoft
 * @Author GaoYang Lee
 * @Date Create in 2020/3/18 14:06
 * @Description This is a good day
 **/
@Controller
public class HelloController {

    @GetMapping("/index")
    public String hello(){
        return "index";
    }

}
