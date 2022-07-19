package com.ytz.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ytz.web.domain.Employee;
import com.ytz.web.model.StatusEnum;

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
    Employee login(String employeeUsername, String employeePassword);

    /**
     * @MethodName: delivery
     * @Description: DONE ：订单完成员工订单数加1
     * @Author: Delmore
     * @date: 2022/7/19
     * @param: employeeId
     * @return: java.lang.Integer  网点Id
     **/
    Integer delivery(Integer employeeId);

    /**
     * @MethodName: queryActiveEmployee
     * @Description: DONE ： 显示在职员工信息（分页）
     * @Author: Delmore
     * @date: 2022/7/12
     * @param: current
     * @param: stationId
     * @return: IPage 在职员工的Vo
     **/
    IPage queryActiveEmployeeVo(Integer current, Integer stationId);

    /**
     * @MethodName: queryActiveEmployee
     * @Description: DONE ： 显示在职员工信息(全查) 用于发工资 (也可用于指派派送员快件)
     * @Author: 30671
     * @date: 2022/7/15
     * @param: stationId
     * @return: List 在职员工的对象
     **/
    List<Employee> queryActiveEmployee(Integer stationId);

    /**
     * @MethodName: queryPreResignationEmployeeVo
     * @Description: DONE ： 查询预辞职的员工信息
     * @Author: 30671
     * @date: 2022/7/13
     * @param: stationId
     * @return: List 预辞职的员工信息
     **/
    IPage queryPreResignationEmployeeVo(Integer current, Integer stationId);


    /**
     * @MethodName: resetPassword
     * @Description: DONE ： 重置员工密码
     * @Author: 30671
     * @date: 2022/7/13
     * @param: employeeIdList 派送员的ListId
     * @return: EmployeeEnum
     **/
    StatusEnum resetPassword(List<Integer> employeeIdList);


    /**
     * @MethodName: consentResignation
     * @Description: DONE ： 审批离职申请
     * @Author: 30671
     * @date: 2022/7/13
     * @param: employeeIdList 派送员的ListId
     * @return: EmployeeEnum
     **/
    StatusEnum consentResignation(List<Integer> employeeIdList, Integer permit);


    /**
     * @MethodName: addEmployee
     * @Description: DONE ： 给网点添加一个员工
     * @Author: 30671
     * @date: 2022/7/16
     * @param: employee    添加的员工信息
     * @return: StatusEnum
     **/
    StatusEnum addEmployee(Employee employee);

    /**
     * @MethodName: resetAmount
     * @Description: DONE ： 发完工资后重置订单数
     * @Author: 30671
     * @date: 2022/7/16
     * @param: employeeId    员工Id
     * @return: StatusEnum
     **/
    StatusEnum resetAmount(Integer employeeId);

    /**
     * @MethodName: submitResignation
     * @Description: DONE : 员工提交离职申请
     * @Author: Delmore
     * @date: 2022/7/19
     * @param: resignReason 离职缘由
     * @param: employeeId 员工ID
     * @return: StatusEnum
     **/
    StatusEnum submitResignation(String resignReason, Integer employeeId);

}
