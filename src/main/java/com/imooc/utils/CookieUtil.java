package com.imooc.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

// Cookie工具类
public class CookieUtil {

    // 设置
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int MaxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(MaxAge);
        response.addCookie(cookie);
    }

    public static void get() {

    }
}
