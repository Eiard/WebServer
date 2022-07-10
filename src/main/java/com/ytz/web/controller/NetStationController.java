package com.ytz.web.controller;

import com.alibaba.fastjson.TypeReference;
import com.ytz.web.domain.NetStation;
import com.ytz.web.model.NetStationEnum;
import com.ytz.web.service.NetStationService;
import com.ytz.web.utils.JsonUtils;
import com.ytz.web.utils.ResultMap;
import com.ytz.web.vo.UpdateInfo;
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

        ResultMap resultMap = new ResultMap();

        try {
            resultMap.setEnum(netStationService.sign(JsonUtils.jsonToObject(netStation, new TypeReference<NetStation>() {
            })));
        } catch (Exception e) {
            resultMap.setEnum(NetStationEnum.FORMAT_ERROR);
        }

        return resultMap.toJson();
    }

    @PostMapping("/fuzzyQueryByStationInfo")
    String fuzzyQueryByStationInfo(@RequestParam String stationInfo) {

        return new ResultMap(NetStationEnum.QUERY_SUCCESS, netStationService.fuzzyQueryByStationInfo(stationInfo)).toJson();
    }

    @PostMapping("/queryAll")
    String queryAll(@RequestParam String adminUsername){
        netStationService.queryAll(adminUsername);
        
        return null;
    }

    @PostMapping("/update")
    String update(@RequestBody String updateInfo) {
        ResultMap resultMap = new ResultMap();
        try {
            resultMap.setEnum(netStationService.updateInform(JsonUtils.jsonToObject(updateInfo, new TypeReference<UpdateInfo>() {
            })));
        } catch (Exception e) {
            resultMap.setEnum(NetStationEnum.FORMAT_ERROR);
        }
        return resultMap.toJson();
    }

}
