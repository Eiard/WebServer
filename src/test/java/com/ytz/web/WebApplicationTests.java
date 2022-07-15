package com.ytz.web;

import com.ytz.web.mapper.*;
import com.ytz.web.service.OrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

@SpringBootTest
class WebApplicationTests {
    @Resource
    NetStationMapper netStationMapper;
    @Resource
    OrdersService ordersService;

    @Test
    void contextLoads() {
        netStationMapper.deleteById(1);
    }

    @Test
    void test() {
    }
}