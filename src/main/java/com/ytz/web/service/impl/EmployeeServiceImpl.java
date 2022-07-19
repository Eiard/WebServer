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
    public Employee login(String employeeUsername, String employeePassword) {
        return lambdaQuery()
                .select(Employee::getEmployeeId,
                        Employee::getIsPass,
                        Employee::getEmployeeType)
                .eq(Employee::getEmployeeUsername, employeeUsername)
                .eq(Employee::getEmployeePassword, employeePassword)
                .one();
    }

    @Override
    public EmployeeEnum sign(Employee employee) {
        if (employeeUsernameIsExist(employee.getEmployeeUsername())) {
            return EmployeeEnum.PRE_SIGN_USERNAME_USED;
        }
        if (commonService.phoneIsExist(employee.getEmployeePhone())) {
            return EmployeeEnum.PRE_SIGN_PHONE_USED;
        }
        save(employee);
        return EmployeeEnum.PRE_SIGN_SUCCESS;
    }

    @Override
    public Integer delivery(String employeeUsername) {
        Employee employee = lambdaQuery()
                .select(Employee::getStationId,
                        Employee::getOrderAmount)
                .eq(Employee::getEmployeeUsername, employeeUsername)
                .one();
        lambdaUpdate()
                .set(Employee::getOrderAmount, employee.getOrderAmount() + 1)
                .eq(Employee::getEmployeeUsername, employeeUsername)
                .update();
        return employee.getStationId();
    }

    @Override
    public IPage queryInEmployee(Integer current, Integer stationId) {
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
                        .eq(Employee::getIsPass, 1));
    }

    @Override
    public List<Employee> queryInEmployee(Integer stationId) {
        return lambdaQuery()
                .select(
                        Employee::getEmployeeId,
                        Employee::getEmployeeName,
                        Employee::getEmployeeType,
                        Employee::getOrderAmount
                )
                .eq(Employee::getStationId, stationId)
                .eq(Employee::getIsPass, 1)
                .or(netStationLambdaQueryWrapper -> {
                    netStationLambdaQueryWrapper.eq(Employee::getIsPass, 2);
                })
                .list();
    }


    @Override
    public IPage queryOutEmployee(Integer current, Integer stationId) {
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
    public boolean employeeUsernameIsExist(String employeeUsername) {
        return lambdaQuery().eq(Employee::getEmployeeUsername, employeeUsername).exists();
    }

    @Override
    public EmployeeEnum submitResignation(String resignReason, String employeeUsername) {
        lambdaUpdate()
                .set(Employee::getResignReason, resignReason)
                .set(Employee::getIsPass, 2)
                .eq(Employee::getEmployeeUsername, employeeUsername)
                .update();
        return EmployeeEnum.SUBMIT_RESIGNATION_SUCCESS;
    }

    @Override
    public EmployeeEnum consentResignation(String employUsername) {
        lambdaUpdate()
                .set(Employee::getEmployeeName, "")
                .set(Employee::getEmployeePhone, "")
                .set(Employee::getIsPass, 3)
                .set(Employee::getResignReason, "")
                .eq(Employee::getEmployeeUsername, employUsername)
                .update();
        return EmployeeEnum.CONSENT_RESIGNATION_SUCCESS;
    }


    public EmployeeEnum resetAmount(Integer employeeId) {
        lambdaUpdate()
                .set(Employee::getOrderAmount, 0)
                .eq(Employee::getEmployeeId, employeeId)
                .update();

        return EmployeeEnum.RESET_AMOUNT_SUCCESS;
    }

    @Override
    public List queryNetStationEmployeeForDispatch(Integer stationId) {

        return listMaps(new LambdaQueryWrapper<Employee>()
                .select(
                        Employee::getEmployeeId,
                        Employee::getEmployeeName,
                        Employee::getEmployeePhone
                )
                .eq(Employee::getStationId, stationId)
                .eq(Employee::getIsPass, 1)
                .or(netStationLambdaQueryWrapper -> {
                    netStationLambdaQueryWrapper.eq(Employee::getIsPass, 2);
                }))
                ;
    }
}