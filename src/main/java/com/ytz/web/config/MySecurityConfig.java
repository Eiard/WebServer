package com.ytz.web.config;

import com.ytz.web.domain.Employee;
import com.ytz.web.interceptors.CommonInterceptor;
import com.ytz.web.interceptors.EmployeeInterceptor;
import com.ytz.web.interceptors.NetStationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: web
 * @package: com.ytz.web.config
 * @className: SecurityConfig
 * @author: Delmore
 * @description: TODO :
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
        commonInclude.add("/public/**/*.html");
        commonInclude.add("/user/*");
        commonInclude.add("/orders/*");
        commonInclude.add("/goodType/*");
        commonInclude.add("/employee/*");
        commonInclude.add("/netStation/*");

        List<String> commonExclude = new ArrayList<>();
        commonExclude.add("/netStation/login");
        commonExclude.add("/netStation/sign");
        commonExclude.add("/employee/login");

        /**
         * @Description: DONE : 没有登录的页面拦截
         **/
        registry.addInterceptor(commonInterceptor)
                .addPathPatterns(commonInclude)
                .excludePathPatterns(commonExclude);


        List<String> netStationInclude = new ArrayList<>();
        netStationInclude.add("/public/netStation/*.html");



        List<String> netStationExclude = new ArrayList<>();





        /**
         * @Description: DONE : 登陆完成后 判断token是否是网点管理员 让他局限在网点管理员的操作
         **/

        registry.addInterceptor(netStationInterceptor)
                .addPathPatterns(netStationInclude)
                .excludePathPatterns(netStationExclude);








        /**
         * @Description: DONE : 判断token是否是网点管理员 让他局限在网点管理员的操作
         **/
       registry.addInterceptor(employeeInterceptor)
               .addPathPatterns()
               .excludePathPatterns();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }

}