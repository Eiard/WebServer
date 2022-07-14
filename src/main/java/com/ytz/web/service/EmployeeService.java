package com.ytz.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ytz.web.domain.Employee;
import com.ytz.web.model.EmployeeEnum;

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
    EmployeeEnum resetPassword(Integer employeeId);

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
     * @MethodName: queryInEmployee
     * @Description: DONE ： 显示在职员工信息（分页）
     * @Author: Delmore
     * @date: 2022/7/12
     * @param: current
     * @return: java.util.List 在职员工的信息
     **/
    IPage queryInEmployee(Integer current,Integer stationId);

    /**
     * @MethodName: queryOutEmployee
     * @Description: DONE : 显示离职员工信息（分页）
     * @Author: Delmore
     * @date: 2022/7/13
     * @param: current
     * @return: java.util.List
     **/
    IPage queryOutEmployee(Integer current,Integer stationId);

    /**
     * @MethodName: employeeUsernameIsExist
     * @Description: DONE : 员工用户名存在
     * @Author: 30671
     * @date: 2022/7/11
     * @param: employeeUsername  员工用户名
     * @return: boolean
     */
    boolean employeeUsernameIsExist(String employeeUsername);
    /**
     * @MethodName: submitResignation
     * @Description: DONE : 员工提交离职申请
     * @Author: Delmore
     * @date: 2022/7/14
     * @return: com.ytz.web.model.EmployeeEnum
     **/
    EmployeeEnum submitResignation(String resignReason,String employeeUsername);

    /**
     * @MethodName: consentResignation
     * @Description: TODO : 同意离职申请
     * @Author: Delmore
     * @date: 2022/7/14
     * @return: com.ytz.web.model.NetStationEnum
     **/
    EmployeeEnum  consentResignation(String employUsername);

    /**
     * @MethodName: findByUsername
     * @Description: DONE : 通过用户名找ID
     * @Author: Delmore
     * @date: 2022/7/14
     * @return: java.lang.Integer
     **/
    Integer findByUsername(String employUsername);
}
