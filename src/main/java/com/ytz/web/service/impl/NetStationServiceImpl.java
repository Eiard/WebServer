package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.NetStation;
import com.ytz.web.mapper.NetStationMapper;
import com.ytz.web.model.NetStationEnum;
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
 * @description: TODO : 针对表【net_station】的数据库操作Service
 * @date: 2022/7/4
 * @version: 1.0
 */
@Service("netStationServiceImpl")
public class NetStationServiceImpl extends ServiceImpl<NetStationMapper, NetStation>
        implements NetStationService {

    @Resource(name = "commonServiceImpl")
    private CommonService commonService;

    @Override
    public NetStationEnum login(String adminUsername, String adminPassword) {
        NetStation netStation = lambdaQuery().select(NetStation::getIsPass)
                .eq(NetStation::getAdminUsername, adminUsername)
                .eq(NetStation::getAdminPassword, adminPassword)
                .one();
        if (netStation == null) {
            return NetStationEnum.LOGIN_FAILED;
        }
        if (netStation.getIsPass() == 0) {
            return NetStationEnum.LOGIN_UNVERIFIED;
        }
        return NetStationEnum.LOGIN_SUCCESS;
    }

    @Override
    public NetStationEnum sign(NetStation netStation) {
        if (adminUsernameIsExist(netStation.getAdminUsername())) {
            return NetStationEnum.PRE_SIGN_USERNAME_USED;
        }
        if (commonService.phoneIsExist(netStation.getAdminPhone())) {
            return NetStationEnum.PRE_SIGN_PHONE_USED;
        }
        save(netStation);
        return NetStationEnum.PRE_SIGN_SUCCESS;
    }

    @Override
    public NetStationEnum updateStationInform(NetStation netStation, String newPassword) {
        NetStation station = lambdaQuery()
                .select(NetStation::getAdminPassword, NetStation::getAdminPhone)
                .eq(NetStation::getAdminUsername, netStation.getAdminUsername())
                .one();
        if (!(netStation.getAdminPassword().equals(station.getAdminPassword()))) {
            return NetStationEnum.CHANCE_FAILED_PASSWORD_ERROR;
        }
        if (commonService.phoneIsExist(netStation.getAdminPhone())) {
            if (!(station.getAdminPhone().equals(netStation.getAdminPhone())))
                return NetStationEnum.CHANGE_FAILED_PHONE_USED;
        }
        lambdaUpdate()
                .set(NetStation::getStationName, netStation.getStationName())
                .set(NetStation::getStationAddress, netStation.getStationAddress())
                .set(NetStation::getAdminName, netStation.getAdminName())
                .set(NetStation::getAdminPhone, netStation.getAdminPhone())
                .set(NetStation::getAdminSex, netStation.getAdminSex())
                .set(NetStation::getAdminPassword, newPassword)
                .eq(NetStation::getAdminUsername, netStation.getAdminUsername())
                .update();
        return NetStationEnum.CHANGE_SUCCESS;
    }

    @Override
    public List fuzzyQueryByStationInfo(String stationInfo) {
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
    public List queryStationInform(String adminUsername) {
        return listMaps(
                new LambdaQueryWrapper<NetStation>()
                        .select(NetStation::getStationName,
                                NetStation::getStationAddress,
                                NetStation::getAdminName,
                                NetStation::getAdminPhone,
                                NetStation::getAdminUsername,
                                NetStation::getAdminSex,
                                NetStation::getOrderAmount)
                        .eq(NetStation::getAdminUsername, adminUsername)
        );
    }


    @Override
    public NetStationEnum delivery(Integer stationId) {
        NetStation netStation = getById(stationId);
        // 总完成订单个数加1
        lambdaUpdate()
                .set(NetStation::getOrderAmount, netStation.getOrderAmount() + 1)
                .eq(NetStation::getStationId, stationId)
                .update();
        return NetStationEnum.DELIVERY_SUCCESS;
    }

    @Override
    public boolean adminUsernameIsExist(String adminUsername) {
        return lambdaQuery().eq(NetStation::getAdminUsername, adminUsername).exists();
    }

    @Override
    public Integer findIdByUsername(String adminUsername) {
        return lambdaQuery()
                .select(NetStation::getStationId)
                .eq(NetStation::getAdminUsername, adminUsername)
                .one().getStationId();
    }

    @Override
    public List<NetStation> queryAllStationInform() {
        return lambdaQuery()
                .select(
                        NetStation::getStationId,
                        NetStation::getAdminName,
                        NetStation::getAdminType,
                        NetStation::getOrderAmount
                )
                .eq(NetStation::getIsPass, 1)
                .or(netStationLambdaQueryWrapper -> {
                    netStationLambdaQueryWrapper.eq(NetStation::getIsPass, 2);
                })
                .list();
    }

    public NetStationEnum resetAmount(Integer stationId) {
        lambdaUpdate()
                .set(NetStation::getOrderAmount, 0)
                .eq(NetStation::getStationId, stationId)
                .update();

        return NetStationEnum.RESET_AMOUNT_SUCCESS;
    }
}