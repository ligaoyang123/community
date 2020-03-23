package com.lee.web.community.controller;

import com.lee.web.community.dto.AccessToken;
import com.lee.web.community.dto.GithubUser;
import com.lee.web.community.provinder.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Company MySteelSoft
 * @Author GaoYang Lee
 * @Date Create in 2020/3/20 14:19
 * @Description This is a good day
 **/
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.clent.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;


    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,
                           @RequestParam("state") String state,
                           HttpServletRequest request){
        AccessToken accessToken = new AccessToken();
        accessToken.setClient_id(clientId);
        accessToken.setCode(code);
        accessToken.setClient_secret(clientSecret);
        accessToken.setRedirect_uri(redirectUri);
        accessToken.setState(state);
        String token = githubProvider.getAccessToken(accessToken);
        GithubUser user = githubProvider.getUser(token);
        System.out.println(user.getName());
        System.out.println(user.getId());
        if(user !=null){
            //登录成功，写cookie和session
            request.getSession().setAttribute("user",user);
            return "redirect:index";
        }else{
            //登录失败 重新登录
            return "redirect:index";
        }

    }
}
