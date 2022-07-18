package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Employee;
import com.ytz.web.domain.Finance;
import com.ytz.web.domain.NetStation;
import com.ytz.web.mapper.FinanceMapper;
import com.ytz.web.model.FinanceEnum;
import com.ytz.web.service.EmployeeService;
import com.ytz.web.service.FinanceService;
import com.ytz.web.service.NetStationService;
import com.ytz.web.utils.SalaryUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service.impl
 * @className: FinanceServiceImpl
 * @author: 30671
 * @description: TODO : 针对表【finance】的数据库操作Service实现
 * @date: 2022/7/5
 * @version: 1.0
 */
@Service("financeServiceImpl")
public class FinanceServiceImpl extends ServiceImpl<FinanceMapper, Finance>
        implements FinanceService {

    @Resource(name = "netStationServiceImpl")
    private NetStationService netStationService;

    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;

    @Override
    public FinanceEnum paySalaryAllNetStation() {

        // 所有网点
        List<NetStation> netStations = netStationService.queryAllStationInform();

        // 单个网点
        for (NetStation netStation : netStations) {
            paySalaryOneNetStation(netStation);
        }

        return FinanceEnum.PAY_SALARY_SUCCESS;
    }

    public FinanceEnum paySalaryOneNetStation(NetStation netStation) {
        // 该网点
        // 网点管理员发工资
        paySalaryAdmin(netStation);

        // 网点其他员工发工资
        paySalaryEmployee(netStation.getStationId());

        return FinanceEnum.PAY_SALARY_SUCCESS;
    }

    @Override
    public FinanceEnum paySalaryAdmin(NetStation netStation) {

        Finance finance = new Finance();

        finance.setEmployeeId(netStation.getStationId());
        finance.setEmployeeName(netStation.getAdminName());
        finance.setOrderAmount(netStation.getOrderAmount());
        finance.setTypeId(netStation.getAdminType());
        // 总工资(税前)
        Double salary = SalaryUtils.calculateSalary(netStation.getAdminType(), netStation.getOrderAmount());
        finance.setSalary(salary);
        finance.setTotalSalary(SalaryUtils.taxDeduction(salary));

        // 抹除该月处理的订单数
        netStationService.resetAmount(netStation.getStationId());

        save(finance);

        return FinanceEnum.PAY_SALARY_SUCCESS;
    }

    @Override
    public FinanceEnum paySalaryEmployee(Integer stationId) {
        List<Employee> employees = employeeService.queryInEmployee(stationId);

        List<Finance> finances = new ArrayList<>();
        for (Employee employee : employees) {
            Finance finance = new Finance();


            finance.setEmployeeId(employee.getEmployeeId());
            finance.setEmployeeName(employee.getEmployeeName());
            finance.setOrderAmount(employee.getOrderAmount());
            finance.setTypeId(employee.getEmployeeType());
            // 总工资(税前)
            Double salary = SalaryUtils.calculateSalary(employee.getEmployeeType(), employee.getOrderAmount());
            finance.setSalary(salary);
            // 存入税后工资
            finance.setTotalSalary(SalaryUtils.taxDeduction(salary));

            // 抹除该月处理的订单数
            employeeService.resetAmount(employee.getEmployeeId());
            finances.add(finance);

        }

        // 发该网点Id的所有 员工的工资
        saveBatch(finances);

        return FinanceEnum.PAY_SALARY_SUCCESS;
    }

    @Deprecated
    @Override
    public FinanceEnum paySalaryRoot(NetStation netStation) {
        return null;
    }


}




