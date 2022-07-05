package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.NetStation;
import com.ytz.web.mapper.NetStationMapper;
import com.ytz.web.model.NetStationEnum;
import com.ytz.web.service.CommonService;
import com.ytz.web.service.NetStationService;
import org.springframework.stereotype.Repository;
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
@Service
@Repository("netStationServiceImpl")
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
    public NetStationEnum update(NetStation netStation) {

        return NetStationEnum.CHANGE_SUCCESS;
    }

    @Override
    public List<NetStation> queryByIdNameAddress(Integer stationId, String stationName, String stationAddress) {
        if (stationId == null) {
            return lambdaQuery().like(NetStation::getStationName, stationName).like(NetStation::getStationAddress, stationAddress).list();
        }
        return lambdaQuery().eq(NetStation::getStationId, stationId).list();
    }

    @Override
    public boolean phoneIsExist(String phone) {
        return lambdaQuery().eq(NetStation::getAdminPhone, phone).exists();
    }

    @Override
    public boolean adminUsernameIsExist(String adminUsername) {
        return lambdaQuery().eq(NetStation::getAdminUsername, adminUsername).exists();
    }
}




