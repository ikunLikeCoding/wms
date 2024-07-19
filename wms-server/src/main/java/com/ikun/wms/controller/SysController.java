package com.ikun.wms.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.code.kaptcha.Producer;
import com.ikun.wms.utils.Result;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * @Author: yiwang
 * @Date: 2024/7/19
 */

@RestController
public class SysController {
    private final static String LOGIN_CAPTCHA_SESSION_KEY = "loginCaptcha";

    private final static String LOGIN_CAPTCHA_SESSION_DATE = "loginCaptchaDate";

    /**
     * captcha expire time, millis
     */
    private final static long VALID_MILLIS_TIME = 30 * 1000 ;

    @Resource
    private Producer captchaProducer;
    @PermitAll
    @RequestMapping("/captcha/captchaImage")
    public Result getKaptchaImage(HttpServletResponse response, HttpServletRequest req) throws Exception {
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("UTF-8");
        String capText = captchaProducer.createText();

        HttpSession session = req.getSession();
        session.setAttribute(LOGIN_CAPTCHA_SESSION_KEY, capText);
        session.setAttribute(LOGIN_CAPTCHA_SESSION_DATE, new Date());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedImage bi = captchaProducer.createImage(capText);
        ImageIO.write(bi, "jpg", outputStream);

        byte[] imageBytes = outputStream.toByteArray();
        String base64Image = "data:image/jpg;base64," + Base64.getEncoder().encodeToString(imageBytes);

        return Result.success(Map.of("img",base64Image));
    }
    @PermitAll
    @ResponseBody
    @PostMapping("/captcha/check")
    public Result checkHomeCaptcha(HttpServletRequest req) {
        String captcha = req.getParameter("captcha");
                if (StringUtils.isEmpty(captcha)) {
            return Result.error("验证码不能为空");
        }
        String savedCaptcha = (String) req.getSession().getAttribute(LOGIN_CAPTCHA_SESSION_KEY);

        Date sessionDate = (Date) req.getSession().getAttribute(LOGIN_CAPTCHA_SESSION_DATE);
        if (captcha.equalsIgnoreCase(savedCaptcha)) {
            if (sessionDate == null
                    || System.currentTimeMillis() - sessionDate.getTime() > VALID_MILLIS_TIME) {
                return Result.error("验证码已过期");
            }
            return Result.success();
        }
        return Result.error("验证码错误");
    }


}
