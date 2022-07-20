package com.ytz.web.config;

import com.ytz.web.interceptors.CommonInterceptor;
import com.ytz.web.interceptors.EmployeeInterceptor;
import com.ytz.web.interceptors.NetStationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: web
 * @package: com.ytz.web.config
 * @className: SecurityConfig
 * @author: Delmore
 * @description: DONE : 实现拦截 过滤请求
 * @date: 2022/7/16 8:55
 * @version: 1.0
 */
@Configuration
public class MySecurityConfig implements WebMvcConfigurer {

    @Resource
    private CommonInterceptor commonInterceptor;

    @Resource
    private NetStationInterceptor netStationInterceptor;

    @Resource
    private EmployeeInterceptor employeeInterceptor;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.html");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> commonInclude = new ArrayList<>();
        commonInclude.add("/**");

        List<String> commonExclude = new ArrayList<>();
        // 静态资源
        commonExclude.add("/css/**");
        commonExclude.add("/fonts/**");
        commonExclude.add("/image/**");
        commonExclude.add("/js/**");
        commonExclude.add("/layout/**");
        commonExclude.add("/layui/**");
        // 页面
        commonExclude.add("/login.html");
        // URL
        commonExclude.add("/netStation/login");
        commonExclude.add("/netStation/sign");
        commonExclude.add("/employee/login");
        commonExclude.add("/finance/**");
        commonExclude.add("/goodType/**");

        /**
         * @Description: DONE : 没有登录的页面拦截
         **/
        registry.addInterceptor(commonInterceptor)
                .addPathPatterns(commonInclude)
                .excludePathPatterns(commonExclude);



        List<String> netStationInclude = new ArrayList<>();
        netStationInclude.add("/public/netStation/**");
        netStationInclude.add("/netStation/**");

        List<String> netStationExclude = new ArrayList<>();
        netStationExclude.add("/netStation/login");
        netStationExclude.add("/netStation/sign");
        netStationExclude.add("/employee/login");

        /**
         * @Description: DONE : 登陆完成后 判断token是否是网点管理员 让他局限在网点管理员的操作
         **/

        registry.addInterceptor(netStationInterceptor)
                .addPathPatterns(netStationInclude)
                .excludePathPatterns(netStationExclude);


        List<String> employeeInclude = new ArrayList<>();
        employeeInclude.add("/public/employee/*.html");
        employeeInclude.add("/employee/**");

        List<String> employeeExclude = new ArrayList<>();
        employeeExclude.add("/netStation/login");
        employeeExclude.add("/netStation/sign");
        employeeExclude.add("/employee/login");

        /**
         * @Description: DONE : 判断token是否是网点管理员 让他局限在网点管理员的操作
         **/
        registry.addInterceptor(employeeInterceptor)
                .addPathPatterns(employeeInclude)
                .excludePathPatterns(employeeExclude);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }

}