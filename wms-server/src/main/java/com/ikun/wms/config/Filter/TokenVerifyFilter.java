package com.ikun.wms.config.Filter;


import com.ikun.wms.utils.*;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TokenVerifyFilter extends OncePerRequestFilter {




    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {

        if(request.getRequestURI().equals(Constants.LOGIN_URI)){
            filterChain.doFilter(request,response);
        }else {
            //从前端请求中获取token
            String token = request.getHeader(Constants.TOKEN_NAME);

            //如果token为空
            if(!StringUtils.hasText(token)){
                Result result = Result.error(CodeEnum.NO_LOGIN);

                String resultJSON = JSONUtils.toJSON(result);

                ResponseUtils.write(response,resultJSON);
                return;
            }

            //如果token无效
            if(!JWTUtils.verifyJWT(token)){
                Result result = Result.error(CodeEnum.TOKEN_ERROR);
                ResponseUtils.write(response, JSONUtils.toJSON(result));
                return;
            }

//            UserInfo user = JWTUtils.parseUserFromJWT(token);





            filterChain.doFilter(request,response);
        }
    }
}
