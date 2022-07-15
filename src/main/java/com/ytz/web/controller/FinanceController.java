package com.ytz.web.controller;

import com.ytz.web.model.FinanceEnum;
import com.ytz.web.service.FinanceService;
import com.ytz.web.utils.ResultMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.controller
 * @className: FinanceController
 * @author: 30671
 * @description: TODO : 负责发工资和工资查询
 * @date: 2022/7/14
 * @version: 1.0
 */
@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Resource(name = "financeServiceImpl")
    private FinanceService financeService;


    @PostMapping("/paySalaryAllNetStation")
    public ResultMap paySalaryAllNetStation() {

        return new ResultMap(financeService.paySalaryAllNetStation());
    }

    @PostMapping("/paySalaryAllRoot")
    public ResultMap paySalaryAllRoot() {

        return new ResultMap(FinanceEnum.PAY_SALARY_SUCCESS);
    }
}
