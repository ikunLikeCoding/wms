package com.ikun.wms.config.Handler;


import com.ikun.wms.utils.CodeEnum;
import com.ikun.wms.utils.JSONUtils;
import com.ikun.wms.utils.ResponseUtils;
import com.ikun.wms.utils.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //登录失败的统一结果
        Result result = Result.error(CodeEnum.NO_LOGIN);

        //把R对象转成json
        String resultJSON = JSONUtils.toJSON(result);

        //把R以json返回给前端
        ResponseUtils.write(response, resultJSON);
    }
}
