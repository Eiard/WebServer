package com.ytz.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: Web
 * @package: ytz.team.web
 * @className: WebApplication
 * @author: 30671
 * @description: DONE
 * @date: 2022/6/28
 * @version: 1.0
 */
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
