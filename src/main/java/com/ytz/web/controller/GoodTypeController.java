package com.ytz.web.controller;

import com.ytz.web.model.GoodTypeEnum;
import com.ytz.web.model.OrdersEnum;
import com.ytz.web.service.GoodTypeService;
import com.ytz.web.service.OrdersService;
import com.ytz.web.utils.JsonUtils;
import com.ytz.web.utils.ResultMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.controller
 * @className: GoodTypeController
 * @author: 30671
 * @description: TODO : 获取货物类别信息
 * @date: 2022/7/15
 * @version: 1.0
 */
@RestController
@RequestMapping("/goodType")
public class GoodTypeController {

    @Resource(name = "goodTypeServiceImpl")
    private GoodTypeService goodTypeService;

    @PostMapping("/getFinalPrice")
    String getFinalPrice(@RequestParam Double goodWeight, @RequestParam Integer goodType) {
        Double finalPrice = goodTypeService.getFinalPrice(goodWeight, goodType);
        return new ResultMap(GoodTypeEnum.GET_PRICE_SUCCESS,finalPrice).toJson();
    }

    @PostMapping("/queryAllGoodType")
    String queryAllGoodType(){
        return new ResultMap(GoodTypeEnum.QUERY_SUCCESS, goodTypeService.queryAllGoodTye()).toJson();
    }
}
