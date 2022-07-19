package com.ytz.web.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @projectName: web
 * @package: com.ytz.web.utils
 * @className: TokenUtils
 * @author: Delmore
 * @description: DONE : 生成和解析 Token
 * @date: 2022/7/17 21:53
 * @version: 1.0
 */
public class TokenUtil {

    /**
     * 生成Token
     * type 根据用户类别生成token
     */
    public static String makeToken(Integer type) {
        return type.toString() + new IdGeneratorSnowflake().snowflakeId();
    }

    /**
     * 从中键值对查找cookie
     * cookie：cookie数组
     */
    public static String getToken(HttpServletRequest request) {
        Cookie[] cookie = request.getCookies();

        if (cookie == null) {
            return null;
        }
        // 键值对查找对应cookie 的 token
        for (Cookie c : cookie) {
            if (c.getName().equals("token")) {
                return c.getValue();
            }
        }
        return null;
    }

    /**
     * 直接解码得到id
     */
    public static Integer getId(HttpServletRequest request) {
        String token = getToken(request);
        HttpSession session = request.getSession();
        return (Integer) session.getAttribute(token);
    }
}
