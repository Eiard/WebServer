package com.ytz.web.controller;

import com.ytz.web.model.StatusEnum;
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
 * @description: DONE : 负责发工资
 * @date: 2022/7/14
 * @version: 1.0
 */
@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Resource(name = "financeServiceImpl")
    private FinanceService financeService;


    @PostMapping("/paySalaryAllNetStation")
    public String paySalaryAllNetStation() {

        return new ResultMap(financeService.paySalaryAllNetStation()).toJson();
    }

    @Deprecated
    @PostMapping("/paySalaryAllRoot")
    public String paySalaryAllRoot() {

        return new ResultMap(StatusEnum.PAY_SALARY_SUCCESS).toJson();
    }
}
