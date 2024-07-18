package com.ikun.wms.config.Handler;


import com.ikun.wms.mapper.UserInfoMapper;
import com.ikun.wms.pojo.entity.User;
import com.ikun.wms.utils.JSONUtils;
import com.ikun.wms.utils.JWTUtils;
import com.ikun.wms.utils.ResponseUtils;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;


@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {



    @Resource
    private UserInfoMapper userMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        //登录成功，执行该方法，在该方法中返回json给前端，就行了
        User user = (User) authentication.getPrincipal();




        //1、生成jwt
        //把tUser对象转成json作为负载数据放入jwt
        String userJSON = JSONUtils.toJSON(user);
        String jwt = JWTUtils.createJWT(userJSON);



//        System.out.println(rememberMe);
//        if(Boolean.parseBoolean(rememberMe)){
//            redisService.expire(Constants.REDIS_JWT_KEY + user.getId(), Constants.EXPIRED_TIME, TimeUnit.SECONDS);
//        }else {
//            redisService.expire(Constants.REDIS_JWT_KEY + user.getId(), Constants.DEFAULT_TIME, TimeUnit.SECONDS);
//        }
        //登录成功的统一结果
        Result<String> result = Result.success(jwt,"登陆成功");

        //把R对象转成json
        String resultJSON = JSONUtils.toJSON(result);

        //把R以json返回给前端
        ResponseUtils.write(response, resultJSON);
    }
}
