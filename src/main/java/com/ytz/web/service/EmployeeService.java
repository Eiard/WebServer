package com.ytz.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ytz.web.domain.Employee;
import com.ytz.web.model.EmployeeEnum;
import java.util.List;

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
     * @MethodName: resetPassword
     * @Description: DONE : 重置员工密码，默认为123456
     * @Author: Delmore
     * @date: 2022/7/12
     * @param: employeeId
     * @return: com.ytz.web.model.EmployeeEnum
     **/
    EmployeeEnum resetPassword(String employeeId);

    /**
     * @MethodName: dispatch
     * @Description: DONE : 通过Id查询员工信息
     * @Author: Delmore
     * @date: 2022/7/12
     * @param: employeeId
     * @return: java.util.Map<java.lang.String, java.lang.String> 姓名和电话
     **/
    Employee dispatch(String employeeId);

    /**
     * @MethodName: queryIncumbentEmployee
     * @Description: DONE ： 显示在职员工信息（分页）
     * @Author: Delmore
     * @date: 2022/7/12
     * @param: current
     * @return: java.util.List 在职员工的信息
     **/
    IPage queryInEmployee(Integer current);

    /**
     * @MethodName: queryOutEmployee
     * @Description: TODO : 显示离职员工信息（分页）
     * @Author: Delmore
     * @date: 2022/7/13
     * @param: current
     * @return: java.util.List
     **/
    IPage queryOutEmployee(Integer current);

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
