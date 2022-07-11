package com.ytz.web.controller;

import com.alibaba.fastjson.TypeReference;
import com.ytz.web.domain.Employee;
import com.ytz.web.model.EmployeeEnum;
import com.ytz.web.service.EmployeeService;
import com.ytz.web.utils.JsonUtils;
import com.ytz.web.utils.ResultMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @projectName: web
 * @package: com.ytz.web.controller
 * @className: EmployeeController
 * @author: Delmore
 * @description: TODO
 * @date: 2022/7/7 12:34
 * @version: 1.0
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;

    @RequestMapping("/login")
    String login(@RequestParam String employeeUsername, @RequestParam String employeePassword) {
        return new ResultMap(employeeService.login(employeeUsername, employeePassword)).toJson();
    }

    @RequestMapping("/sign")
    String sign(@RequestParam String employee) {
        ResultMap resultMap = new ResultMap();
        try {
            resultMap.setEnum(employeeService.sign(JsonUtils.jsonToObject(employee, new TypeReference<Employee>() {
            })));
        } catch (Exception e) {
            resultMap.setEnum(EmployeeEnum.FORMAT_ERROR);
        }
        return resultMap.toJson();
    }

    @RequestMapping("/delivery")
    String delivery(@RequestParam String employeeUsername) {
        Employee employee = new Employee();
        employee.setEmployeeName("王五");
        employee.setEmployeeUsername("user3");
        employee.setEmployeePassword("123456");
        employee.setEmployeeSex(true);
        employee.setEmployeePhone("125151674");
        employee.setEmployeeType(true);





        return "1";
    }
}