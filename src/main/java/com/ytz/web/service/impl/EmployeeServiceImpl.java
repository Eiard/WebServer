package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Employee;
import com.ytz.web.service.EmployeeService;
import com.ytz.web.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

/**
* @author 30671
* @description 针对表【employee】的数据库操作Service实现
* @createDate 2022-07-04 19:01:18
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

}




