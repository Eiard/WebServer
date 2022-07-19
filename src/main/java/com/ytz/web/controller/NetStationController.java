package com.ytz.web.controller;

import com.alibaba.fastjson.TypeReference;
import com.ytz.web.domain.NetStation;
import com.ytz.web.model.NetStationEnum;
import com.ytz.web.service.EmployeeService;
import com.ytz.web.service.NetStationService;
import com.ytz.web.service.OrdersService;
import com.ytz.web.utils.JsonUtils;
import com.ytz.web.utils.ResultMap;
import com.ytz.web.utils.TokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.controller
 * @className: NetStationController
 * @author: 30671
 * @description: TODO : 管理员操作
 * @date: 2022/7/4
 * @version: 1.0
 */
@RestController
@RequestMapping("/netStation")
public class NetStationController {

    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;

    @Resource(name = "netStationServiceImpl")
    private NetStationService netStationService;

    @Resource(name = "ordersServiceImpl")
    private OrdersService ordersService;

    @PostMapping("/login")
    String login(@RequestParam String adminUsername,
                 @RequestParam String adminPassword,
                 HttpSession session) {
        ResultMap resultMap = new ResultMap();

        NetStation netStation = netStationService.login(adminUsername, adminPassword);

        if (netStation == null) {
            resultMap.setEnum(NetStationEnum.LOGIN_FAILED);
        } else if (netStation.getIsPass() == 0) {
            resultMap.setEnum(NetStationEnum.LOGIN_UNVERIFIED);
        } else {
            resultMap.setEnum(NetStationEnum.LOGIN_SUCCESS);

            // 根据类别生成token
            String token = TokenUtil.makeToken(netStation.getAdminType());

            // 存stationId
            session.setAttribute(token, netStation.getStationId());

            resultMap.setToken(token);
        }
        return resultMap.toJson();
    }

    @PostMapping("/sign")
    String sign(@RequestParam String netStation) {
        ResultMap resultMap = new ResultMap();
        try {
            resultMap.setEnum(netStationService.sign(JsonUtils.jsonToObject(netStation, new TypeReference<NetStation>() {
            })));
        } catch (Exception e) {
            resultMap.setEnum(NetStationEnum.FORMAT_ERROR);
        }
        return resultMap.toJson();
    }

    @PostMapping("/queryStationInform")
    String queryStationInform(HttpServletRequest request) {

        return new ResultMap(
                NetStationEnum.QUERY_SUCCESS,
                netStationService.queryStationInfoById(TokenUtil.getId(request)))
                .toJson();
    }

    @PostMapping("/updateStationInform")
    String update(@RequestParam String netStation,
                  @RequestParam String newPassword) {

        ResultMap resultMap = new ResultMap();
        try {
            resultMap.setEnum(netStationService.updateStationInform(JsonUtils.jsonToObject(netStation, new TypeReference<NetStation>() {
            }), newPassword));
        } catch (Exception e) {
            resultMap.setEnum(NetStationEnum.FORMAT_ERROR);
        }
        return resultMap.toJson();
    }

}