package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.NetStation;
import com.ytz.web.mapper.NetStationMapper;
import com.ytz.web.model.NetStationEnum;
import com.ytz.web.service.NetStationService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


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
@Service
@Repository("netStationServiceImpl")
public class NetStationServiceImpl extends ServiceImpl<NetStationMapper, NetStation>
        implements NetStationService {

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


        return NetStationEnum.PRE_SIGN_SUCCESS;
    }

    @Override
    public boolean phoneIsExist(String phone) {
        return lambdaQuery().eq(NetStation::getAdminPhone, phone).exists();
    }
}




