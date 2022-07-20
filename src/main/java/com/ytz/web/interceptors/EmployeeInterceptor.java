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
 * @className: EmployeeInterceptor
 * @author: Delmore
 * @description: DONE : (权限控制)判断请求是否是Employee
 * @date: 2022/7/18 15:55
 * @version: 1.0
 */
@Component
public class EmployeeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = TokenUtil.getToken(request);

        HttpSession session = request.getSession(false);

        // 不是网点管理员的访问
        if (!token.substring(0, 1).equals("3")) {
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
