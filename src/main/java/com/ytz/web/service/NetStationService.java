package com.ytz.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ytz.web.domain.NetStation;
import com.ytz.web.model.NetStationEnum;

import java.util.List;

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
     * @MethodName: login
     * @Description: DONE : 实现网点管理员登录判断
     * @Author: 30671
     * @date: 2022/7/4
     * @param: adminUsername  账号
     * @param: adminPassword  密码
     * @return: com.ytz.web.model.NetStationServiceEnum
     */
    NetStationEnum login(String adminUsername, String adminPassword);

    /**
     * @MethodName: sign
     * @Description: DONE : 账号预注册
     * @Author: 30671
     * @date: 2022/7/4
     * @param: netStation  网点信息
     * @return: com.ytz.web.model.NetStationServiceEnum
     */
    NetStationEnum sign(NetStation netStation);

    /**
     * @MethodName: update
     * @Description: TODO : 账号更新信息
     * @Author: 30671
     * @date: 2022/7/5
     * @param: netStation  网点信息
     * @return: com.ytz.web.model.NetStationServiceEnum
     */
    public NetStationEnum update(NetStation netStation);

    /**
     * @MethodName: queryByIdNameAddress
     * @Description: DONE : 通过 stationId stationName stationAddress 模糊查询
     * @Author: 30671
     * @date: 2022/7/5
     * @param: stationId  网点Id
     * @param: stationName  网点名称
     * @param: stationAddress  网点地址
     * @return: List<NetStation>
     */
    List<NetStation> queryByIdNameAddress(Integer stationId, String stationName, String stationAddress);

    /**
     * @MethodName: phoneIsExist
     * @Description: DONE : 手机号存在
     * @Author: 30671
     * @date: 2022/7/5
     * @param: phone  手机号
     * @return: boolean
     */
    boolean phoneIsExist(String phone);

    /**
     * @MethodName: adminUsernameIsExist
     * @Description: DONE : 用户名存在
     * @Author: 30671
     * @date: 2022/7/5
     * @param: adminUsername  用户名
     * @return: boolean
     */
    boolean adminUsernameIsExist(String adminUsername);
}

