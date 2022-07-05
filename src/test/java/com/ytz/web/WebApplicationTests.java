package com.ytz.web;

import com.ytz.web.service.NetStationService;
import com.ytz.web.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WebApplicationTests {

    @Resource
    NetStationService netStationService;

    @Test
    void contextLoads() {
        System.out.println(JsonUtils.objectToJson(netStationService.getById(1)));
    }

}
