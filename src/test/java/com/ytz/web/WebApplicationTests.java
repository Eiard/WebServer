package com.ytz.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ytz.web.domain.GoodType;
import com.ytz.web.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WebApplicationTests {
    @Resource
    NetStationMapper netStationMapper;

    @Test
    void contextLoads() {
        netStationMapper.deleteById(1);
    }

}