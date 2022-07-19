package com.ytz.web.interceptors;

import com.ytz.web.utils.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @projectName: web
 * @package: com.ytz.web.interceptors
 * @className: CommonInterceptor
 * @author: Delmore
 * @description: TODO :
 * @date: 2022/7/18 15:55
 * @version: 1.0
 */
@Component
public class CommonInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = TokenUtil.getToken(request);

        HttpSession session = request.getSession(false);

        // token为null  session不存在 session找不到键值对
        if (token == null || session == null || session.getAttribute(token) == null) {
            response.sendRedirect("/login.html");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
