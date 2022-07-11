package com.ytz.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ytz.web.domain.Employee;
import com.ytz.web.model.EmployeeEnum;
import com.ytz.web.model.OrdersEnum;

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
     * @Description: DONE : 实现员工登录
     * @Author: 30671
     * @date: 2022/7/4
     * @param: employeeUsername  员工账号
     * @param: employeePassword  员工密码
     * @return: com.ytz.web.model.EmployeeEnum
     */
    EmployeeEnum login(String employeeUsername, String employeePassword);


    /**
     * @MethodName: sign
     * @Description: DONE : 实现员工注册
     * @Author: 30671
     * @date: 2022/7/4
     * @param: employee   员工信息
     * @return: com.ytz.web.model.EmployeeEnum
     */
    EmployeeEnum sign(Employee employee);

    /**
     * @MethodName: delivery
     * @Description: DONE : 派送完成
     * @Author: 30671
     * @date: 2022/7/4
     * @param: employeeUsername   员工账号
     * @return: stationId 网点Id
     */
    Integer delivery(String employeeUsername);

    /**
     * @MethodName: employeeUsernameIsExist
     * @Description: DONE : 员工用户名存在
     * @Author: 30671
     * @date: 2022/7/11
     * @param: employeeUsername  员工用户名
     * @return: boolean
     */
    boolean employeeUsernameIsExist(String employeeUsername);
}
