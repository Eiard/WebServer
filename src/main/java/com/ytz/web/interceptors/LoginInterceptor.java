package com.ytz.web.interceptors;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ytz.web.service.EmployeeService;
import com.ytz.web.service.NetStationService;
import com.ytz.web.utils.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @projectName: web
 * @package: com.ytz.web.interceptors
 * @className: EmployeeInterceptor
 * @author: Delmore
 * @description: TODO :
 * @date: 2022/7/17 9:15
 * @version: 1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURL());
        String token = TokenUtil.getRequestToken(request);
        if (token ==null){
            String tk = TokenUtil.makeToken();
            response.setHeader("token", tk);
            System.out.println(tk);
            return true;
        }else return token.equals("session.getToken");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
