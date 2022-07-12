package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Employee;
import com.ytz.web.mapper.EmployeeMapper;
import com.ytz.web.model.EmployeeEnum;
import com.ytz.web.model.variable.NetStationVar;
import com.ytz.web.service.CommonService;
import com.ytz.web.service.EmployeeService;
import com.ytz.web.vo.IncumbentEmployeeVO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


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
@Service("employeeServiceImpl")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
        implements EmployeeService {

    @Resource(name = "commonServiceImpl")
    private CommonService commonService;

    @Override
    public EmployeeEnum login(String employeeUsername, String employeePassword) {
        Employee employee = lambdaQuery()
                .select(Employee::getIsPass)
                .eq(Employee::getEmployeeUsername, employeeUsername)
                .eq(Employee::getEmployeePassword, employeePassword)
                .one();
        if (employee == null) {
            return EmployeeEnum.LOGIN_FAILED;
        }
        if (!(employee.getIsPass())) {
            return EmployeeEnum.LOGIN_UNVERIFIED;
        }
        return EmployeeEnum.LOGIN_SUCCESS;
    }

    @Override
    public EmployeeEnum sign(Employee employee) {
        if (employeeUsernameIsExist(employee.getEmployeeUsername())) {
            return EmployeeEnum.PRE_SIGN_USERNAME_USED;
        }
        if (commonService.phoneIsExist(employee.getEmployeePhone())) {
            return EmployeeEnum.PRE_SIGN_PHONE_USED;
        }
        save(employee);
        return EmployeeEnum.PRE_SIGN_SUCCESS;
    }

    @Override
    public Integer delivery(String employeeUsername) {
        Employee employee = lambdaQuery()
                .select(Employee::getStationId, Employee::getOrderAmount)
                .eq(Employee::getEmployeeUsername, employeeUsername)
                .one();
        lambdaUpdate()
                .set(Employee::getOrderAmount, employee.getOrderAmount() + 1)
                .eq(Employee::getEmployeeUsername, employeeUsername)
                .update();
        return employee.getStationId();
    }

    @Override
    public EmployeeEnum resetPassword(String employeeId) {
        lambdaUpdate().set(Employee::getEmployeePassword, "123456")
                .eq(Employee::getEmployeeId, employeeId)
                .update();
        return EmployeeEnum.RESET_PASSWORD_SUCCESS;
    }

    @Override
    public Employee dispatch(String employeeId) {
        return getById(employeeId);
    }

    @Override
    public boolean employeeUsernameIsExist(String employeeUsername) {
        return lambdaQuery().eq(Employee::getEmployeeUsername, employeeUsername).exists();
    }

    @Override
    public List<IncumbentEmployeeVO> queryInEmployee(Integer current) {
        ArrayList<IncumbentEmployeeVO> inEmployeeList = new ArrayList<>();
        try {
            IPage page = new Page(current, NetStationVar.PAGE_SIZE);
            LambdaQueryWrapper<Employee> lqw = new LambdaQueryWrapper<Employee>();
            lqw.select(Employee::getEmployeeId, Employee::getEmployeeName, Employee::getEmployeeUsername,
                    Employee::getEmployeeSex, Employee::getEmployeePhone, Employee::getOrderAmount,
                    Employee::getCreateDate).eq(Employee::getIsPass, 1);
            getBaseMapper().selectPage(page, lqw);
            List<Employee> employeeList = page.getRecords();
            for (int i = 0; i < employeeList.size(); i++) {
                IncumbentEmployeeVO inEmployee = new IncumbentEmployeeVO();
                BeanUtils.copyProperties(inEmployee, employeeList.get(i));
                inEmployeeList.add(inEmployee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inEmployeeList;
    }
}




