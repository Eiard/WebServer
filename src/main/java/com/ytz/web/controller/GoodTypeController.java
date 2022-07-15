package com.ytz.web.controller;

import com.ytz.web.utils.ResultMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    //登录注册功能
    @GetMapping("/queryGoodType")
    String queryGoodType() {


        return new ResultMap().toJson();
    }
}
