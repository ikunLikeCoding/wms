package com.ikun.wms.utils;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


/***
 * @Author: Wang
 *
 * @Description:
 * 响应工具类
 */
public class ResponseUtils {

    /**
     * 使用response，把结果写出到前端
     *
     * @param response
     * @param result ResultUtil中返回值
     */
    public static void write(HttpServletResponse response, String result) {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(result);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
