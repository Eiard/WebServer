package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.NetStation;
import com.ytz.web.mapper.NetStationMapper;
import com.ytz.web.model.StatusEnum;
import com.ytz.web.service.CommonService;
import com.ytz.web.service.NetStationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service.impl
 * @className: NetStationServiceImpl
 * @author: 30671
 * @description: DONE : 针对表【net_station】的数据库操作Service
 * @date: 2022/7/4
 * @version: 1.0
 */
@Service("netStationServiceImpl")
public class NetStationServiceImpl extends ServiceImpl<NetStationMapper, NetStation>
        implements NetStationService {

    @Resource(name = "commonServiceImpl")
    private CommonService commonService;

    @Override
    public NetStation login(String adminUsername, String adminPassword) {
        return lambdaQuery()
                .select(NetStation::getStationId,
                        NetStation::getIsPass,
                        NetStation::getAdminType)
                .eq(NetStation::getAdminUsername, adminUsername)
                .eq(NetStation::getAdminPassword, adminPassword)
                .one();
    }

    @Override
    public StatusEnum sign(NetStation netStation) {
        if (lambdaQuery().eq(NetStation::getAdminUsername, netStation.getAdminUsername()).exists()) {
            return StatusEnum.PRE_SIGN_USERNAME_USED;
        }
        if (commonService.phoneIsExist(netStation.getAdminPhone())) {
            return StatusEnum.PRE_SIGN_PHONE_USED;
        }
        save(netStation);
        return StatusEnum.PRE_SIGN_SUCCESS;
    }

    @Override
    public List queryStationVoById(Integer stationId) {

        return listMaps(
                new LambdaQueryWrapper<NetStation>()
                        .select(NetStation::getStationName,
                                NetStation::getStationAddress,
                                NetStation::getAdminName,
                                NetStation::getAdminPhone,
                                NetStation::getAdminUsername,
                                NetStation::getAdminSex,
                                NetStation::getOrderAmount)
                        .eq(NetStation::getStationId, stationId)
        );
    }

    @Override
    public NetStation queryStationById(Integer stationId) {
        return lambdaQuery()
                .eq(NetStation::getStationId, stationId)
                .one();
    }

    @Override
    public StatusEnum updateStationInform(NetStation netStation, String newPassword) {
        NetStation station = getById(netStation.getStationId());
        if (!(netStation.getAdminPassword().equals(station.getAdminPassword()))) {
            return StatusEnum.CHANCE_FAILED_PASSWORD_ERROR;
        }
        if (commonService.phoneIsExist(netStation.getAdminPhone())) {
            if (!(station.getAdminPhone().equals(netStation.getAdminPhone())))
                return StatusEnum.CHANGE_FAILED_PHONE_USED;
        }
        lambdaUpdate()
                .set(NetStation::getStationName, netStation.getStationName())
                .set(NetStation::getStationAddress, netStation.getStationAddress())
                .set(NetStation::getAdminName, netStation.getAdminName())
                .set(NetStation::getAdminPhone, netStation.getAdminPhone())
                .set(NetStation::getAdminSex, netStation.getAdminSex())
                .set(NetStation::getAdminPassword, newPassword)
                .eq(NetStation::getStationId, netStation.getStationId())
                .update();
        return StatusEnum.CHANGE_SUCCESS;
    }


    @Override
    public List fuzzyQueryByStationVo(String stationInfo) {
        return listMaps(
                new LambdaQueryWrapper<NetStation>()
                        .select(NetStation::getStationId,
                                NetStation::getStationName,
                                NetStation::getStationAddress
                        )
                        .like(NetStation::getStationName, stationInfo)
                        .or(netStationLambdaQueryWrapper -> {
                            netStationLambdaQueryWrapper
                                    .like(NetStation::getStationAddress, stationInfo);
                        }));
    }




    @Override
    public List<NetStation> queryAllStation() {
        return lambdaQuery().select().list();
    }


    @Override
    public StatusEnum resetAmount(Integer stationId) {
        lambdaUpdate()
                .set(NetStation::getOrderAmount, 0)
                .eq(NetStation::getStationId, stationId)
                .update();

        return StatusEnum.RESET_AMOUNT_SUCCESS;
    }


    @Override
    public StatusEnum delivery(Integer stationId) {
        NetStation netStation = getById(stationId);
        // 总完成订单个数加1
        lambdaUpdate()
                .set(NetStation::getOrderAmount, netStation.getOrderAmount() + 1)
                .eq(NetStation::getStationId, stationId)
                .update();
        return StatusEnum.DELIVERY_SUCCESS;
    }



}