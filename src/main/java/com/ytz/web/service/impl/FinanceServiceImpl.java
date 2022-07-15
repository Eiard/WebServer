package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Finance;
import com.ytz.web.domain.NetStation;
import com.ytz.web.mapper.FinanceMapper;
import com.ytz.web.model.FinanceEnum;
import com.ytz.web.service.FinanceService;
import com.ytz.web.service.NetStationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service.impl
 * @className: FinanceServiceImpl
 * @author: 30671
 * @description: TODO : 针对表【finance】的数据库操作Service实现
 * @date: 2022/7/5
 * @version: 1.0
 */
@Service("financeServiceImpl")
public class FinanceServiceImpl extends ServiceImpl<FinanceMapper, Finance>
        implements FinanceService {

    @Resource(name = "netStationServiceImpl")
    private NetStationService netStationService;

    @Override
    public FinanceEnum paySalaryAllNetStation() {

        // 所有网点
        List<NetStation> netStations = netStationService.queryAllStationInform();

        // 单个网点
        for (NetStation netStation : netStations) {
            paySalaryOneNetStation(netStation);
        }

        return FinanceEnum.PAY_SALARY_SUCCESS;
    }

    public FinanceEnum paySalaryOneNetStation(NetStation netStation) {

        // 该网点
        // 网点管理员发工资
        paySalaryAdmin(netStation);

        // 网点其他员工发工资
        paySalaryEmployee(netStation.getStationId());

        return FinanceEnum.PAY_SALARY_SUCCESS;
    }

    @Override
    public FinanceEnum paySalaryAdmin(NetStation netStation) {
        return null;
    }

    @Override
    public FinanceEnum paySalaryEmployee(Integer stationId) {
        return null;
    }

    @Deprecated
    @Override
    public FinanceEnum paySalaryRoot(NetStation netStation) {
        return null;
    }
}




