package com.ytz.web.service.impl;

import com.ytz.web.mapper.CommonMapper;
import com.ytz.web.service.CommonService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service.impl
 * @className: CommonService
 * @author: 30671
 * @description: TODO : 不同service都会用到的相同操作
 * @date: 2022/7/5
 * @version: 1.0
 */
@Service
@Repository("commonServiceImpl")
public class CommonServiceImpl implements CommonService {

    @Resource(name = "commonMapper")
    private CommonMapper commonMapper;

    @Override
    public boolean phoneIsExist(String phone) {
        return commonMapper.phoneIsExist(phone);
    }

}
