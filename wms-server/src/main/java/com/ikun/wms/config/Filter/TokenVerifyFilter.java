package com.ikun.wms.config.Filter;


import com.ikun.wms.pojo.entity.User;
import com.ikun.wms.utils.*;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class TokenVerifyFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
//        System.out.println(request.getRequestURI());
        if(request.getRequestURI().equals(Constants.LOGIN_URI)||
                request.getRequestURI().equals(Constants.CAPTCHA_CHECK_URI)||
                request.getRequestURI().equals(Constants.CAPTCHA_URI)){
            filterChain.doFilter(request,response);
        }else {
            //从前端请求中获取token
            String token = request.getHeader(Constants.TOKEN_NAME);
            System.out.println(token);
            //如果token为空
            if(!StringUtils.hasText(token)){

                Result result = Result.error(CodeEnum.NO_LOGIN);

                String resultJSON = JSONUtils.toJSON(result);

                ResponseUtils.write(response,resultJSON);
                return;
            }

//            System.out.println(token);
            if(!JWTUtils.verifyJWT(token)){//如果token无效
                Result result = Result.error(CodeEnum.TOKEN_ERROR);
                ResponseUtils.write(response,JSONUtils.toJSON(result));
                return;
            }

            User user = JWTUtils.parseUserFromJWT(token);


            //在SecurityContextHolder中设置认证信息
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user,user.getUserPwd(),user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);





            filterChain.doFilter(request,response);
        }
    }
}
