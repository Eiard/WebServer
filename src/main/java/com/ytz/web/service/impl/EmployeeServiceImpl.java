package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Employee;
import com.ytz.web.mapper.EmployeeMapper;
import com.ytz.web.model.EmployeeEnum;
import com.ytz.web.service.CommonService;
import com.ytz.web.service.EmployeeService;
import com.ytz.web.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service.impl
 * @className: EmployeeServiceImpl
 * @author: 30671
 * @description: TODO : 针对表【employee】的数据库操作Service实现
 * @date: 2022/7/5
 * @version: 1.0
 */
@Service("employeeServiceImpl")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
        implements EmployeeService {

    @Resource(name = "commonServiceImpl")
    private CommonService commonService;


    @Override
    public IPage queryActiveEmployeeVo(Integer current, Integer stationId) {
        return pageMaps(PageUtils.getEmployeePage(current),
                new LambdaQueryWrapper<Employee>()
                        .select(
                                Employee::getEmployeeId,
                                Employee::getEmployeeName,
                                Employee::getEmployeeUsername,
                                Employee::getEmployeeSex,
                                Employee::getEmployeePhone,
                                Employee::getOrderAmount,
                                Employee::getCreateDate
                        )
                        .eq(Employee::getStationId, stationId)
                        .eq(Employee::getIsPass, 1)
                        .or(netStationLambdaQueryWrapper -> {
                            netStationLambdaQueryWrapper.eq(Employee::getIsPass, 2);
                        }));
    }

    @Override
    public List<Employee> queryActiveEmployee(Integer stationId) {
        return lambdaQuery()
                .select(
                        Employee::getEmployeeId,
                        Employee::getEmployeeName,
                        Employee::getEmployeeType,
                        Employee::getOrderAmount,
                        Employee::getEmployeePhone
                )
                .eq(Employee::getStationId, stationId)
                .eq(Employee::getIsPass, 1)
                .or(netStationLambdaQueryWrapper -> {
                    netStationLambdaQueryWrapper.eq(Employee::getIsPass, 2);
                })
                .list();
    }

    @Override
    public IPage queryPreResignationEmployeeVo(Integer current, Integer stationId) {
        return pageMaps(PageUtils.getEmployeePage(current),
                new LambdaQueryWrapper<Employee>()
                        .select(
                                Employee::getEmployeeId,
                                Employee::getEmployeeName,
                                Employee::getEmployeeUsername,
                                Employee::getEmployeeSex,
                                Employee::getEmployeePhone,
                                Employee::getResignReason
                        )
                        .eq(Employee::getStationId, stationId)
                        .eq(Employee::getIsPass, 2));
    }

    @Override
    public EmployeeEnum resetPassword(List<Integer> employeeIdList) {
        for (Integer integer : employeeIdList) {
            lambdaUpdate()
                    .set(Employee::getEmployeePassword, "123456")
                    .eq(Employee::getEmployeeId, integer)
                    .update();
        }
        return EmployeeEnum.RESET_PASSWORD_SUCCESS;
    }

    @Override
    public EmployeeEnum consentResignation(List<Integer> employeeIdList, Integer permit) {
        if (permit == 0) {
            // 不让离职 则将状态位搬回 并且清空离职原因
            for (Integer integer : employeeIdList) {
                lambdaUpdate()
                        .set(Employee::getIsPass, 1)
                        .set(Employee::getResignReason, "")
                        .eq(Employee::getEmployeeId, integer)
                        .update();
            }
            return EmployeeEnum.REFUSE_RESIGNATION_SUCCESS;
        } else if (permit == 1) {
            // 允许离职 则将状态位设置为离职 清空信息
            for (Integer integer : employeeIdList) {
                lambdaUpdate()
                        .set(Employee::getEmployeeName, "")
                        .set(Employee::getEmployeePhone, "")
                        .set(Employee::getIsPass, 3)
                        .set(Employee::getResignReason, "")
                        .eq(Employee::getEmployeeId, integer)
                        .update();
            }
            return EmployeeEnum.CONSENT_RESIGNATION_SUCCESS;
        }

        return EmployeeEnum.UNKNOWN_ERROR;
    }

    @Override
    public EmployeeEnum addEmployee(Employee employee) {
        if (lambdaQuery().eq(Employee::getEmployeeUsername, employee.getEmployeeUsername()).exists()) {
            return EmployeeEnum.PRE_SIGN_USERNAME_USED;
        }
        if (commonService.phoneIsExist(employee.getEmployeePhone())) {
            return EmployeeEnum.PRE_SIGN_PHONE_USED;
        }
        save(employee);
        return EmployeeEnum.PRE_SIGN_SUCCESS;
    }

}