package com.ytz.web.controller;

import com.ytz.web.service.FinanceService;
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






}
