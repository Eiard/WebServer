package com.ytz.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: Web
 * @package: ytz.team.web
 * @className: WebApplication
 * @author: 30671
 * @description: DONE : SpringBoot Main Class
 * @date: 2022/6/28
 * @version: 1.0
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {                  //每次打开服务器不需要输入账号密码
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@ComponentScan(basePackages={"com.ytz.web.*"})
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        try {
            Runtime.getRuntime().exec("cmd   /c   start   http://localhost:8080/login");//可以指定自己的路径
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}