package com.ytz.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ytz.web.domain.Finance;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service
 * @className: FinanceService
 * @author: 30671
 * @description: TODO : 针对表【finance】的数据库操作Service
 * @date: 2022/7/4
 * @version: 1.0
 */
public interface FinanceService extends IService<Finance> {

    /**
     * @MethodName: paySalaryPerNetStation
     * @Description: DONE : 实现网点Id(一次性结算整个网点工资) 对网点所有员工进行发工资,月结
     * @Author: 30671
     * @date: 2022/7/14
     * @param: stationId  网点Id
     * @return: com.ytz.web.model.EmployeeEnum
     */
    Finance paySalaryPerNetStation(Integer stationId);

}
