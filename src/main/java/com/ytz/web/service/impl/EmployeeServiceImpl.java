package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Employee;
import com.ytz.web.service.EmployeeService;
import com.ytz.web.mapper.EmployeeMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
@Service
@Repository("employeeServiceImpl")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

}




