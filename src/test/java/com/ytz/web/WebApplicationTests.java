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
    RootMapper rootMapper;
    @Resource
    NetStationMapper netStationMapper;
    @Resource
    CommonMapper commonMapper;

    @Test
    void contextLoads() {
        IPage page = new Page(1,2);
        rootMapper.selectPage(page,null);
        System.out.println("当前页码值:"+page.getCurrent());
        System.out.println("每页显示的数目:"+page.getSize());
        System.out.println("总页数:"+page.getPages());
        System.out.println("数据:"+page.getRecords());
        System.out.println("总数据数:"+page.getTotal());
    }

    @Test
    void test(){
        netStationMapper.deleteById(1);
    }
    @Test
    void test2(){
        System.out.println(commonMapper.phoneIsExist("1"));
    }
}