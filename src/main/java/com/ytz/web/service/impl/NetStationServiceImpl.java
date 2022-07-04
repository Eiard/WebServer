package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.Enum.service.NetStationServiceEnum;
import com.ytz.web.domain.NetStation;
import com.ytz.web.mapper.NetStationMapper;
import com.ytz.web.service.NetStationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 30671
 * @description 针对表【net_station】的数据库操作Service实现
 * @createDate 2022-07-04 19:51:46
 */
@Service
public class NetStationServiceImpl extends ServiceImpl<NetStationMapper, NetStation>
        implements NetStationService {

    @Resource
    private NetStationMapper netStationMapper;

    @Override
    public NetStationServiceEnum login(String adminUsername, String adminPassword) {

        LambdaQueryWrapper<NetStation> wrapper = new LambdaQueryWrapper();
        wrapper.eq(NetStation::getAdminName, adminUsername);

        if (wrapper.isEmptyOfEntity()) {
            // 账号不存在
            return NetStationServiceEnum.LOGIN_FAILED;
        }

        NetStation netStation = baseMapper.selectOne(wrapper);

        if (netStation.getIsPass() == 0) {
            // 未审核
            return NetStationServiceEnum.LOGIN_UNVERIFIED;
        }

        if (netStation.getAdminPassword().equals(adminPassword)) {
            // 登陆成功
            return NetStationServiceEnum.LOGIN_SUCCESS;
        }
        // 密码错误
        return NetStationServiceEnum.LOGIN_FAILED;
    }


}




