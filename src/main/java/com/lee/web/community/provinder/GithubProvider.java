package com.lee.web.community.provinder;



import com.alibaba.fastjson.JSON;
import com.lee.web.community.dto.AccessToken;
import com.lee.web.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Company MySteelSoft
 * @Author GaoYang Lee
 * @Date Create in 2020/3/20 14:25
 * @Description This is a good day
 **/
@Component
public class GithubProvider {
    @Value("${github.url}")
    private String url;
    @Value("${github.app.url}")
    private String appUrl;

    public String getAccessToken(AccessToken accessToken) {
        MediaType json = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(json, JSON.toJSONString(accessToken));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                String[] split = string.split("&");
                String s = split[0];
                String token = s.split("=")[1];
                System.out.println(string);
                return token;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(appUrl+accessToken)
                .build();
        try{
            Response execute = client.newCall(request).execute();
            String string = execute.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
