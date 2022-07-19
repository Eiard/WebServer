package com.ytz.web.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
     * @MethodName: queryInEmployee
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
    EmployeeEnum resetPassword(List<Integer> employeeIdList);



    /**
     * @MethodName: consentResignation
     * @Description: DONE ： 审批离职申请
     * @Author: 30671
     * @date: 2022/7/13
     * @param: employeeIdList 派送员的ListId
     * @return: EmployeeEnum
     **/
    EmployeeEnum consentResignation(List<Integer> employeeIdList, Integer permit) ;


    /**
     * @MethodName: addEmployee
     * @Description: DONE ： 给网点添加一个员工
     * @Author: 30671
     * @date: 2022/7/16
     * @param: employee    添加的员工信息
     * @return: EmployeeEnum
     **/
     EmployeeEnum addEmployee(Employee employee);
}
