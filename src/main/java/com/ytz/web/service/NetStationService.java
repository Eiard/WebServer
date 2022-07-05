package com.ytz.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ytz.web.Enum.NetStationEnum;
import com.ytz.web.domain.NetStation;

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
     * @Description: DONE : 实现网点管理员登录判断
     * @Author: 30671
     * @date: 2022/7/4
     * @param: adminUsername  账号
     * @param: adminPassword  密码
     * @return: com.ytz.web.Enum.service.NetStationServiceEnum
     */
    NetStationEnum login(String adminUsername, String adminPassword);

    /**
     * @MethodName: sign
     * @Description: TODO : 账号预注册
     * @Author: 30671
     * @date: 2022/7/4
     * @param: netStation  网点信息
     * @return: com.ytz.web.Enum.service.NetStationServiceEnum
     */
    public NetStationEnum sign(NetStation netStation);


}

