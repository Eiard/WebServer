package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.Enum.service.NetStationEnum;
import com.ytz.web.domain.NetStation;
import com.ytz.web.mapper.NetStationMapper;
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

        lambdaQuery().select(NetStation::getIsPass).eq(NetStation::getAdminName, adminUsername).eq(NetStation::getAdminName, adminPassword);
        NetStation netStation = lambdaQuery().one();

        // 账号和密码有误
        if (netStation == null) {
            return NetStationEnum.LOGIN_FAILED;
        }
        // 未审核
        if (netStation.getIsPass() == 0) {
            return NetStationEnum.LOGIN_UNVERIFIED;
        }

        // 登录成功
        return NetStationEnum.LOGIN_SUCCESS;
    }


}




