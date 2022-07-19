package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Employee;
import com.ytz.web.mapper.EmployeeMapper;
import com.ytz.web.model.StatusEnum;
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
    public Employee login(String employeeUsername, String employeePassword) {
        return lambdaQuery()
                .eq(Employee::getEmployeeUsername, employeeUsername)
                .eq(Employee::getEmployeePassword, employeePassword)
                .one();

    }

    @Override
    public Integer delivery(Integer employeeId) {
        Employee employee = getById(employeeId);

        lambdaUpdate()
                .set(Employee::getOrderAmount, employee.getOrderAmount() + 1)
                .eq(Employee::getEmployeeId, employeeId)
                .update();

        return employee.getStationId();
    }


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
    public StatusEnum resetPassword(List<Integer> employeeIdList) {
        for (Integer integer : employeeIdList) {
            lambdaUpdate()
                    .set(Employee::getEmployeePassword, "123456")
                    .eq(Employee::getEmployeeId, integer)
                    .update();
        }
        return StatusEnum.RESET_PASSWORD_SUCCESS;
    }

    @Override
    public StatusEnum consentResignation(List<Integer> employeeIdList, Integer permit) {
        if (permit == 0) {
            // 不让离职 则将状态位搬回 并且清空离职原因
            for (Integer integer : employeeIdList) {
                lambdaUpdate()
                        .set(Employee::getIsPass, 1)
                        .set(Employee::getResignReason, "")
                        .eq(Employee::getEmployeeId, integer)
                        .update();
            }
            return StatusEnum.REFUSE_RESIGNATION_SUCCESS;
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
            return StatusEnum.CONSENT_RESIGNATION_SUCCESS;
        }

        return StatusEnum.UNKNOWN_ERROR;
    }

    @Override
    public StatusEnum addEmployee(Employee employee) {
        if (lambdaQuery().eq(Employee::getEmployeeUsername, employee.getEmployeeUsername()).exists()) {
            return StatusEnum.PRE_SIGN_USERNAME_USED;
        }
        if (commonService.phoneIsExist(employee.getEmployeePhone())) {
            return StatusEnum.PRE_SIGN_PHONE_USED;
        }
        save(employee);
        return StatusEnum.PRE_SIGN_SUCCESS;
    }

    @Override
    public StatusEnum resetAmount(Integer employeeId) {
        lambdaUpdate()
                .set(Employee::getOrderAmount, 0)
                .eq(Employee::getEmployeeId, employeeId)
                .update();
        return StatusEnum.RESET_AMOUNT_SUCCESS;
    }

    @Override
    public StatusEnum submitResignation(String resignReason, Integer employeeId) {
        lambdaUpdate()
                .set(Employee::getResignReason, resignReason)
                .set(Employee::getIsPass, 2)
                .eq(Employee::getEmployeeId, employeeId)
                .update();
        return StatusEnum.SUBMIT_RESIGNATION_SUCCESS;
    }

    @Override
    public StatusEnum updateEmployeeInform(Employee employee, String newPassword) {
        Employee emp = getById(employee.getEmployeeId());
        if (!(employee.getEmployeePassword().equals(emp.getEmployeePassword()))) {
            return StatusEnum.CHANCE_FAILED_PASSWORD_ERROR;
        }
        if (commonService.phoneIsExist(emp.getEmployeePhone())) {
            if (!(emp.getEmployeePhone().equals(employee.getEmployeePhone())))
                return StatusEnum.CHANGE_FAILED_PHONE_USED;
        }
        lambdaUpdate()
                .set(Employee::getEmployeeName, employee.getEmployeeName())
                .set(Employee::getEmployeeSex, employee.getEmployeeSex())
                .set(Employee::getEmployeePassword, newPassword)
                .set(Employee::getEmployeePhone, employee.getEmployeePhone())
                .eq(Employee::getEmployeeId, employee.getEmployeeId())
                .update();
        return StatusEnum.CHANGE_SUCCESS;
    }

    @Override
    public List queryEmployeeVoById(Integer employeeId) {
        return listMaps(
                new LambdaQueryWrapper<Employee>()
                        .select(Employee::getEmployeeId,
                                Employee::getEmployeeName,
                                Employee::getEmployeeSex,
                                Employee::getEmployeeUsername,
                                Employee::getEmployeePhone,
                                Employee::getStationId)
                        .eq(Employee::getEmployeeId, employeeId)
        );
    }

}