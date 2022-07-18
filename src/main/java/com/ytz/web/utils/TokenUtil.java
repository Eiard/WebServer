package com.ytz.web.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import sun.misc.BASE64Encoder;
import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @projectName: web
 * @package: com.ytz.web.utils
 * @className: TokenUtils
 * @author: Delmore
 * @description: TODO :
 * @date: 2022/7/17 21:53
 * @version: 1.0
 */
public class TokenUtil {

    /**
     * 生成Token
     * Token：Nv6RRuGEVvmGjB+jimI/gw==
     *
     * @return
     */
    public static String makeToken() {  //checkException
        //  7346734837483  834u938493493849384  43434384
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        //数据指纹   128位长   16个字节  md5
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());
            //base64编码--任意二进制编码明文字符
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取请求的token
     */
    public static String getRequestToken(HttpServletRequest httpRequest) {

        //从header中获取token
        String token = httpRequest.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = httpRequest.getParameter("token");
        }
        return token;
    }
}
