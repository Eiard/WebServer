package com.ytz.web.service;

import com.ytz.web.Enum.service.NetStationServiceEnum;
import com.ytz.web.domain.NetStation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service
 * @className: NetStationService
 * @author: 30671
 * @description: TODO : 针对表【net_station】的数据库操作Service
 * @date: 2022/7/4
 * @version: 1.0
 */
public interface NetStationService extends IService<NetStation> {

    /**
     * @MethodName: Login
     * @Description: TODO
     * @Author: 30671
     * @date: 2022/7/4 
     * @param: adminUsername
     * @param: adminPassword
     * @return: com.ytz.web.Enum.service.NetStationServiceEnum
     */
    NetStationServiceEnum login(String adminUsername, String adminPassword);
}

