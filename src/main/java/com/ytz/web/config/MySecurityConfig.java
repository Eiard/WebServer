// package com.ytz.web.config;
//
// import com.ytz.web.interceptors.LoginInterceptor;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.*;
// import javax.annotation.Resource;
// import java.util.ArrayList;
// import java.util.List;
//
//
// /**
//  * @projectName: web
//  * @package: com.ytz.web.config
//  * @className: SecurityConfig
//  * @author: Delmore
//  * @description: TODO
//  * @date: 2022/7/16 8:55
//  * @version: 1.0
//  */
// @Configuration
// public class MySecurityConfig implements WebMvcConfigurer {
//
//     @Resource
//     private LoginInterceptor loginInterceptor;
//
//     @Override
//     public void addResourceHandlers(ResourceHandlerRegistry registry) {
//         //注册拦截器，对商家管理系统进行权限验证
//         registry.addResourceHandler("/login.html").addResourceLocations("classpath:/static/login.html");
//     }
//
//     @Override
//     public void addInterceptors(InterceptorRegistry registry) {
//         List<String> patterns = new ArrayList();
//         patterns.add("/login.html");
//         patterns.add("/error");
//         registry.addInterceptor(loginInterceptor)
//                 .addPathPatterns("/**")
//                 .excludePathPatterns(patterns);
//     }
//
//     @Override
//     public void addViewControllers(ViewControllerRegistry registry) {
//         registry.addViewController("/login").setViewName("/login.html");
//     }
// }