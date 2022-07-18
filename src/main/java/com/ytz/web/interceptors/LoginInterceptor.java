// package com.ytz.web.interceptors;
//
// import com.alibaba.fastjson.JSON;
// import org.springframework.stereotype.Component;
// import org.springframework.web.servlet.HandlerInterceptor;
// import org.springframework.web.servlet.ModelAndView;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// /**
//  * @projectName: web
//  * @package: com.ytz.web.interceptors
//  * @className: EmployeeInterceptor
//  * @author: Delmore
//  * @description: TODO
//  * @date: 2022/7/17 9:15
//  * @version: 1.0
//  */
// @Component
// public class LoginInterceptor implements HandlerInterceptor {
//     @Override
//     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//         return true;
//     }
//
//     @Override
//     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//     }
//
//     @Override
//     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//     }
//
// //    private static void setReturn(HttpServletResponse response, int status, String msg) throws IOException {
// //        HttpServletResponse httpResponse = (HttpServletResponse) response;
// //        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
// //        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
// //        //UTF-8编码
// //        httpResponse.setCharacterEncoding("UTF-8");
// //        response.setContentType("application/json;charset=utf-8");
// //        Result build = Result.build(status, msg);
// //        String json = JSON.toJSONString(build);
// //        httpResponse.getWriter().print(json);
// //    }
// }
