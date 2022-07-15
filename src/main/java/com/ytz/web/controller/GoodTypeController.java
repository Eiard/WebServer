package com.ytz.web.controller;

import com.ytz.web.model.OrdersEnum;
import com.ytz.web.service.OrdersService;
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

    @Resource(name = "ordersServiceImpl")
    private OrdersService ordersService;

    @PostMapping("/getFinalPrice")
    String getFinalPrice(@RequestParam Double goodWeight, @RequestParam Integer goodType) {
        Double finalPrice = ordersService.getFinalPrice(goodWeight, goodType);
        return new ResultMap(OrdersEnum.ACHIEVE_PRICE_SUCCESS,finalPrice).toJson();
    }
}
