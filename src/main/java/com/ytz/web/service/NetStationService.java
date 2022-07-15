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
     * @MethodName: updateStationInform
     * @Description: DONE : 账号更新信息
     * @Author: Delmore
     * @date: 2022/7/5
     * @param: netStation  网点信息
     * @return: com.ytz.web.model.NetStationServiceEnum
     */
    NetStationEnum updateStationInform(NetStation netStation, String newPassword);

    /**
     * @MethodName: fuzzyQueryByStationInfo
     * @Description: DONE : 通过 stationInfo => stationName stationAddress 模糊查询
     * @Author: 30671
     * @date: 2022/7/5
     * @param: stationInfo  既可以是网点名称 也可以是网店地址
     * @return: List<NetStation>
     */
    List fuzzyQueryByStationInfo(String stationInfo);

    /**
     * @MethodName: queryStationInform
     * @Description: DONE : 网点管理员查询所有信息
     * @Author: Delmore
     * @date: 2022/7/8
     * @param: adminUsername  网点账号
     * @return: List<NetStation>
     **/
    List queryStationInform(String adminUsername);

    /**
     * @MethodName: delivery
     * @Description: DONE : 通过网点Id 完成一个订单则增加数量
     * @Author: 30671
     * @date: 2022/7/11
     * @param: stationId  网点Id
     * @return: com.ytz.web.model.NetStationServiceEnum
     */
    NetStationEnum delivery(Integer stationId);

    /**
     * @MethodName: adminUsernameIsExist
     * @Description: DONE : 用户名存在
     * @Author: 30671
     * @date: 2022/7/5
     * @param: adminUsername  用户名
     * @return: boolean
     */
    boolean adminUsernameIsExist(String adminUsername);

    /**
     * @MethodName: findIdByUsername
     * @Description: DONE ：通过用户名找ID
     * @Author: Delmore
     * @date: 2022/7/14
     * @param: adminUsername
     * @return: java.lang.Integer 网点Id
     **/
    Integer findIdByUsername(String adminUsername);

    /**
     * @MethodName: queryAllStationInform
     * @Description: DONE : 查询所有网点信息(用于网点管理员发工资)
     * @Author: 30671
     * @date: 2022/7/15
     * @return: List<NetStation>
     */
    List<NetStation> queryAllStationInform();

    /**
     * @MethodName: resetAmount
     * @Description: DONE : 更新该月的处理订单数量
     * @Author: 30671
     * @date: 2022/7/16
     * @param: employeeId  网点Id
     * @return: NetStationEnum
     */
    NetStationEnum resetAmount(Integer stationId);
}

