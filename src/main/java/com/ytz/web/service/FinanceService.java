package com.ytz.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ytz.web.domain.Finance;
import com.ytz.web.domain.NetStation;
import com.ytz.web.model.FinanceEnum;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service
 * @className: FinanceService
 * @author: 30671
 * @description: TODO : 针对表【finance】的数据库操作Service
 * @date: 2022/7/15
 * @version: 1.0
 */
public interface FinanceService extends IService<Finance> {

    /**
     * @MethodName: paySalaryPerNetStation
     * @Description: DONE : 实现所有的网点所有员工发工资
     * @Author: 30671
     * @date: 2022/7/15
     * @return: com.ytz.web.model.FinanceEnum
     */
    FinanceEnum paySalaryAllNetStation();

    /**
     * @MethodName: paySalaryPerNetStation
     * @Description: DONE : 实现一个网点所有员工发工资
     * @Author: 30671
     * @date: 2022/7/14
     * @param: netStation  网点信息
     * @return: com.ytz.web.model.FinanceEnum
     */
    FinanceEnum paySalaryOneNetStation(NetStation netStation);

    /**
     * @MethodName: paySalaryAdmin
     * @Description: DONE : 发网点管理员工资
     * @Author: 30671
     * @date: 2022/7/15
     * @param: netStation  网点信息
     * @return: com.ytz.web.model.FinanceEnum
     */
    FinanceEnum paySalaryAdmin(NetStation netStation);

    /**
     * @MethodName: paySalaryEmployee
     * @Description: DONE : 发网点所有员工工资
     * @Author: 30671
     * @date: 2022/7/15
     * @param: stationId  网点Id
     * @return: com.ytz.web.model.FinanceEnum
     */
    FinanceEnum paySalaryEmployee(Integer stationId);

    /**
     * @MethodName: paySalaryPerNetStation
     * @Description: TODO : Root 员工所有发工资
     * @Author: 30671
     * @date: 2022/7/14
     * @param: netStation  网点信息
     * @return: com.ytz.web.model.FinanceEnum
     */
    @Deprecated
    FinanceEnum paySalaryRoot(NetStation netStation);

    /**
     * @MethodName: queryNetStationSalary
     * @Description: DONE : 查询网点管理员工资记录
     * @Author: Delmore
     * @date: 2022/7/19
     * @param: netStationId 网点Id
     * @param: current 页数
     * @return: com.baomidou.mybatisplus.core.metadata.IPage
     **/
    IPage querySalary(Integer id, Integer typeId, Integer current);

}
