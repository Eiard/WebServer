package com.ytz.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ytz.web.domain.Employee;
import com.ytz.web.domain.Orders;
import com.ytz.web.model.OrdersEnum;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service
 * @className: OrdersService
 * @author: 30671
 * @description: TODO : 针对表【orders】的数据库操作Service
 * @date: 2022/7/4
 * @version: 1.0
 */
public interface OrdersService extends IService<Orders> {
    /**
     * @MethodName: dispatch
     * @Description: DONE : 网点管理员指定派送员配送并修改订单标志位
     * @Author: Delmore
     * @date: 2022/7/11
     * @param: orderNumber
     * @return: com.ytz.web.model.OrdersEnum
     **/
    OrdersEnum dispatch(String orderNumber, Employee employee);

    /**
     * @MethodName: delivery
     * @Description: DONE : 派送员配送完成并修改订单标志位，修改订单逻辑删除位
     * @Author: Delmore
     * @date: 2022/7/11
     * @param: orderNumber
     * @return: com.ytz.web.model.OrdersEnum
     **/
    OrdersEnum delivery(String orderNumber);

    /**
     * @MethodName: createOrder
     * @Description: DONE ： 创建订单
     * @Author: Delmore
     * @date: 2022/7/14
     * @return: com.ytz.web.model.OrdersEnum
     **/
    OrdersEnum createOrder(Orders orderAmount);

}
