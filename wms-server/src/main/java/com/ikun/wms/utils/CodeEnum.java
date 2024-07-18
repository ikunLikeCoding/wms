package com.ikun.wms.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeEnum {
    SUCCESS(200,"成功"),
    ERROR(500,"失败"),
    NO_LOGIN(401,"未登录"),
    NO_PERMISSION(403,"无权限"),
    NOT_FOUND(404,"未找到"),
    SERVER_ERROR(500,"服务器错误"),
    PARAM_ERROR(400,"参数错误"),
    NO_DATA(204,"无数据"),
    DATA_ACCESS_DENY(409,"数据访问失败"),
    NO_AUTH(402,"无权限"),
    NO_ROLE(403,"无权限"),
    NO_USER(404,"用户不存在"),
    NO_PASSWORD(405,"密码错误"),
    TOKEN_EXPIRED(406,"身份信息过期"),
    TOKEN_ERROR(407,"身份信息错误"),
    LOGOUT(408,"退出成功"),
    ;

    private final Integer code;
    private final String msg;
}
