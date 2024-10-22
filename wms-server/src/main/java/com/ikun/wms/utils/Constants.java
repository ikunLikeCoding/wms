package com.ikun.wms.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Constants {
    public static final String REDIS_CACHED_KEY = "crm:cached:";

    public static final String LOGIN_URI = "/wms/api/user/login";

    public static final String LOGOUT_URI = "/wms/api/logout";
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    public static final String TOKEN_NAME = "Authorization";


    public static final String CAPTCHA_URI = "/wms/api/captcha/captchaImage";
    public static final String CAPTCHA_CHECK_URI = "/wms/api/captcha/check";
    public static final String STATIC_RESOURCES_URL = "/wms/static/**";
    public static final List<String> WHITE_URL_LIST = List.of(
            LOGIN_URI,
            LOGOUT_URI,
            CAPTCHA_URI,
            CAPTCHA_CHECK_URI,
            STATIC_RESOURCES_URL
    );

}
