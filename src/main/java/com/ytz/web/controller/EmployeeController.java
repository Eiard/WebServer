package com.ytz.web.controller;

import com.ytz.web.model.EmployeeEnum;
import com.ytz.web.service.EmployeeService;
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
    String login(@RequestParam String employeeUsername, @RequestParam String employeePassword){
        return new ResultMap(employeeService.login(employeeUsername, employeePassword)).toJson();
    }

}