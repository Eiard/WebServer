package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.NetStation;
import com.ytz.web.mapper.NetStationMapper;
import com.ytz.web.model.NetStationEnum;
import com.ytz.web.service.CommonService;
import com.ytz.web.service.NetStationService;
import com.ytz.web.vo.FuzzyQueryStationVO;
import com.ytz.web.vo.QueryAllVO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
    public List<FuzzyQueryStationVO> fuzzyQueryByStationInfo(String stationInfo) {
        List<FuzzyQueryStationVO> fuzzyQueryStationVOS = new ArrayList<>();
        try {
            List<NetStation> netStations = lambdaQuery()
                    .select(NetStation::getStationId,
                            NetStation::getStationName,
                            NetStation::getStationAddress)
                    .like(NetStation::getStationName, stationInfo)
                    .or(netStationLambdaQueryWrapper -> {
                        netStationLambdaQueryWrapper
                                .like(NetStation::getStationAddress, stationInfo);
                    }).list();
            for (NetStation netStation : netStations) {
                FuzzyQueryStationVO fuzzyQueryStationVO = new FuzzyQueryStationVO();
                BeanUtils.copyProperties(fuzzyQueryStationVO, netStation);
                fuzzyQueryStationVOS.add(fuzzyQueryStationVO);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return fuzzyQueryStationVOS;
    }

    @Override
    public QueryAllVO queryAllInform(String adminUsername) {
        QueryAllVO queryAllInfo = null;
        try {
            NetStation station = lambdaQuery()
                    .select(NetStation::getStationName,
                            NetStation::getStationAddress, NetStation::getAdminName,
                            NetStation::getAdminPhone, NetStation::getAdminUsername,
                            NetStation::getAdminSex, NetStation::getOrderAmount)
                    .eq(NetStation::getAdminUsername, adminUsername)
                    .one();
            queryAllInfo = new QueryAllVO();
            BeanUtils.copyProperties(queryAllInfo, station);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return queryAllInfo;
    }


    @Override
    public boolean adminUsernameIsExist(String adminUsername) {
        return lambdaQuery().eq(NetStation::getAdminUsername, adminUsername).exists();
    }


}