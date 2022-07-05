package com.ytz.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WebApplicationTests {

    @Resource
    CommonMapper commonMapper;

    @Test
    void contextLoads() {
        System.out.println(commonMapper.phoneIsExist("21512"));
    }

}
