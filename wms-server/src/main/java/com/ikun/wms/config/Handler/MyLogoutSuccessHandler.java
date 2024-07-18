package com.ikun.wms.config.Handler;


import com.ikun.wms.pojo.entity.User;
import com.ikun.wms.utils.CodeEnum;
import com.ikun.wms.utils.JSONUtils;
import com.ikun.wms.utils.ResponseUtils;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 退出成功处理器
 *
 */
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //退出成功，执行该方法，在该方法中返回json给前端，就行了
        User user = (User)authentication.getPrincipal();

        SecurityContextHolder.clearContext();


        //退出成功的统一结果
        Result result = Result.success(CodeEnum.LOGOUT);

        //把Result对象转成json
        String resultJSON = JSONUtils.toJSON(result);

        //把Result以json返回给前端
        ResponseUtils.write(response, resultJSON);
    }
}
