package com.ytz.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ytz.web.domain.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.mapper
 * @className: EmployeeMapper
 * @author: 30671
 * @description: DONE : 针对表【employee】的数据库操作Mapper
 * @date: 2022/7/4
 * @Entity com.ytz.web.domain.Employee
 * @version: 1.0
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}




