package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.Enum.service.NetStationServiceEnum;
import com.ytz.web.domain.NetStation;
import com.ytz.web.mapper.NetStationMapper;
import com.ytz.web.service.NetStationService;
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
public class NetStationServiceImpl extends ServiceImpl<NetStationMapper, NetStation>
        implements NetStationService {

    @Override
    public NetStationServiceEnum login(String adminUsername, String adminPassword) {

        QueryWrapper<NetStation> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("is_pass").eq("admin_username", adminUsername).eq("admin_password", adminPassword);

        NetStation netStation = getOne(queryWrapper);

        // 账号和密码有误
        if (netStation == null) {
            return NetStationServiceEnum.LOGIN_FAILED;
        }
        // 未审核
        if (netStation.getIsPass() == 0) {
            return NetStationServiceEnum.LOGIN_UNVERIFIED;
        }

        // 登录成功
        return NetStationServiceEnum.LOGIN_SUCCESS;
    }


}




