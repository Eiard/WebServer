package com.ytz.web.service;

import com.ytz.web.domain.GoodType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service
 * @className: GoodTypeService
 * @author: 30671
 * @description: TODO : 针对表【good_type】的数据库操作Service
 * @date: 2022/7/4
 * @version: 1.0
 */
public interface GoodTypeService extends IService<GoodType> {
    /**
     * @MethodName: selectAllGoodTye
     * @Description: DONE : 查询所有货物类别
     * @Author: Delmore
     * @date: 2022/7/17
     * @return: java.util.List 所有货物类别的list集合
     **/
    List queryAllGoodTye();
    /**
     * @MethodName: getFinalPrice
     * @Description: DONE : 获取订单价格
     * @Author: Delmore
     * @date: 2022/7/15
     * @param: orderAmount
     * @return: java.lang.Double
     **/
    Double getFinalPrice(Double goodWeight,Integer goodType);
}
