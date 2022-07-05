package com.ytz.web.controller;

import com.ytz.web.domain.NetStation;
import com.ytz.web.service.NetStationService;
import com.ytz.web.utils.JsonUtils;
import com.ytz.web.utils.ResultMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.controller
 * @className: NetStationController
 * @author: 30671
 * @description: TODO :
 * @date: 2022/7/4
 * @version: 1.0
 */
@RestController
@RequestMapping("/netStation")
public class NetStationController {

    @Resource(name = "netStationServiceImpl")
    private NetStationService netStationService;

    @PostMapping("/login")
    String login(@RequestParam String adminUsername, @RequestParam String adminPassword) {
        return new ResultMap(netStationService.login(adminUsername, adminPassword)).toJson();
    }

    @PostMapping("/sign")
    String sign(@RequestParam NetStation netStation) {
        return new ResultMap(netStationService.sign(netStation)).toJson();
    }

    @PostMapping("/tx")
    String tx(){

        System.out.println(JsonUtils.objectToJson(netStationService.getById(1)));
        return JsonUtils.objectToJson(netStationService.getById(1));
    }

}
