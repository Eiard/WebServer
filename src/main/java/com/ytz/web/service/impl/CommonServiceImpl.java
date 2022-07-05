package com.ytz.web.service.impl;

import com.ytz.web.service.CommonService;
import com.ytz.web.service.EmployeeService;
import com.ytz.web.service.NetStationService;
import com.ytz.web.service.RootService;
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

    @Resource(name = "rootServiceImpl")
    private RootService rootService;

    @Resource(name = "netStationServiceImpl")
    private NetStationService netStationService;

    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;


    @Override
    public boolean phoneIsExist(String phone) {
        return rootService.phoneIsExist(phone)
                || netStationService.phoneIsExist(phone)
                || employeeService.phoneIsExist(phone);
    }
}