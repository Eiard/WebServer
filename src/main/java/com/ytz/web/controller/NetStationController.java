package com.ytz.web.controller;

import com.alibaba.fastjson.TypeReference;
import com.ytz.web.domain.NetStation;
import com.ytz.web.model.NetStationEnum;
import com.ytz.web.service.NetStationService;
import com.ytz.web.utils.JsonUtils;
import com.ytz.web.utils.ResultMap;
import org.springframework.web.bind.annotation.*;

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
    String sign(@RequestBody String netStation) {

        return new ResultMap(netStationService.sign(JsonUtils.jsonToObject(netStation, new TypeReference<NetStation>() {
        }))).toJson();
    }

    @PostMapping("/queryByIdNameAddress")
    String queryByIdNameAddress(@RequestParam String stationId, @RequestParam String stationName, @RequestParam String stationAddress) {

        ResultMap resultMap = new ResultMap(NetStationEnum.FORMAT_ERROR);

        try {
            if (stationId.equals("")) {
                resultMap.setData(netStationService.queryByIdNameAddress(null, stationName, stationAddress));
            } else {
                resultMap.setData(netStationService.queryByIdNameAddress(Integer.parseInt(stationId), stationName, stationAddress));
            }

            resultMap.setEnum(NetStationEnum.QUERY_SUCCESS);
        } catch (Exception e) {
            return resultMap.toJson();
        }

        return resultMap.toJson();
    }

    @PostMapping("/update")
    String update(@RequestBody String netStation){


        return new ResultMap().toJson();
    }
}
