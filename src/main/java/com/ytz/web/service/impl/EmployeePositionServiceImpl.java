package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.EmployeePosition;
import com.ytz.web.mapper.EmployeePositionMapper;
import com.ytz.web.service.EmployeePositionService;
import org.springframework.stereotype.Service;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service.impl
 * @className: EmployeePositionServiceImpl
 * @author: 30671
 * @description: FIXME : 针对表【employee_position】的数据库操作Service实现(后续选择性实现)
 * @date: 2022/7/11
 * @version: 1.0
 */
@Deprecated
@Service("employeePositionServiceImpl")
public class EmployeePositionServiceImpl extends ServiceImpl<EmployeePositionMapper, EmployeePosition>
        implements EmployeePositionService {

}




