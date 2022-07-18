package com.ytz.web.config;

import com.ytz.web.interceptors.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: web
 * @package: com.ytz.web.config
 * @className: SecurityConfig
 * @author: Delmore
 * @description: TODO
 * @date: 2022/7/16 8:55
 * @version: 1.0
 */
@Configuration
public class MySecurityConfig extends WebMvcConfigurerAdapter  {

    @Bean
    public LoginInterceptor LoginInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = new ArrayList();
        patterns.add("/login.html");
        patterns.add("/netStation/**");
        patterns.add("/error");
             registry.addInterceptor(LoginInterceptor())
                .addPathPatterns("/**")
             .excludePathPatterns(patterns);

    }


}