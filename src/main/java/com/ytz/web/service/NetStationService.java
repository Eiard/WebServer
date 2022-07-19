package com.ytz.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ytz.web.domain.NetStation;
import com.ytz.web.model.StatusEnum;

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
     * @return: NetStation
     */
    NetStation login(String adminUsername, String adminPassword);

    /**
     * @MethodName: sign
     * @Description: DONE : 账号预注册
     * @Author: 30671
     * @date: 2022/7/4
     * @param: netStation  网点信息
     * @return: NetStationEnum
     */
    StatusEnum sign(NetStation netStation);

    /**
     * @MethodName: queryStationVoById
     * @Description: DONE : 网点管理员查询个人信息
     * @Author: Delmore
     * @date: 2022/7/8
     * @param: stationId  网点Id
     * @return: List
     **/
    List queryStationVoById(Integer stationId);

    /**
     * @MethodName: queryStationVoById
     * @Description: DONE : 网点管理员查询个人对象
     * @Author: Delmore
     * @date: 2022/7/8
     * @param: stationId  网点Id
     * @return: NetStation
     **/
    NetStation queryStationById(Integer stationId);

    /**
     * @MethodName: updateStationInform
     * @Description: DONE : 账号更新信息
     * @Author: Delmore
     * @date: 2022/7/5
     * @param: netStation  网点信息
     * @return: NetStationEnum
     */
    StatusEnum updateStationInform(NetStation netStation, String newPassword);

    /**
     * @MethodName: fuzzyQueryByStationVo
     * @Description: DONE : 查询网点信息(用于创建订单)
     * @Author: Delmore
     * @date: 2022/7/5
     * @param: netStation  网点信息
     * @return: List
     */
    List fuzzyQueryByStationVo(String stationInfo);

    /**
     * @MethodName: queryAllStationInform
     * @Description: DONE : 查询所有网点
     * @Author: Delmore
     * @date: 2022/7/19
     * @return: java.util.List<com.ytz.web.domain.NetStation> 所有网点的list集合
     **/
    List<NetStation> queryAllStation();

    /**
     * @MethodName: resetAmount
     * @Description: DONE ：重置网点订单数
     * @Author: Delmore
     * @date: 2022/7/19
     * @param: stationId
     * @return: StatusEnum
     **/
    StatusEnum resetAmount(Integer stationId);


    /**
     * @MethodName: delivery
     * @Description: DONE ：订单完成，网点订单数量加1
     * @Author: Delmore
     * @date: 2022/7/19
     * @param: stationId 网点ID
     * @return: com.ytz.web.model.NetStationEnum
     **/
    StatusEnum delivery(Integer stationId);
}

