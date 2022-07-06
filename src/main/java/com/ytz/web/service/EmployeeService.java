package com.ytz.web.service;

import com.ytz.web.model.EmployeeEnum;
import com.ytz.web.domain.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service
 * @className: EmployeeService
 * @author: 30671
 * @description: TODO : 针对表【employee】的数据库操作Service
 * @date: 2022/7/4
 * @version: 1.0
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * @MethodName: login
     * @Description: TODO : 实现员工登录
     * @Author: 30671
     * @date: 2022/7/4
     * @param: employeeUsername  员工账号
     * @param: employeePassword  员工密码
     * @return: com.ytz.web.model.NetStationServiceEnum
     */
    EmployeeEnum login(String employeeUsername, String adminPassword);

    /**
     * @MethodName: phoneIsExist
     * @Description: DONE : 手机号存在
     * @Author: 30671
     * @date: 2022/7/5
     * @param: phone  手机号
     * @return: boolean
     */
    boolean phoneIsExist(String phone);
}
