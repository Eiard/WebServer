package com.ytz.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ytz.web.domain.Employee;
import com.ytz.web.domain.Orders;
import com.ytz.web.model.OrdersEnum;

import java.util.List;

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
     * @Description: DONE : 订单绑定派送员 并修改订单标志位
     * @Author: Delmore
     * @date: 2022/7/11
     * @param: orderNumber
     * @param: employee
     * @return: com.ytz.web.model.OrdersEnum
     **/
    OrdersEnum dispatch(List<String> orderNumber, Employee employee);

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

    /**
     * @MethodName: queryOrderByOrderNumber
     * @Description: DONE : 每个网点只能查询 发出的订单 或者 收到的订单
     * @Author: 30671
     * @date: 2022/7/17
     * @param: stationId    发货网点 或 收货网点     Id
     * @param: current      当前要访问的页数
     * @param: orderNumber  为空则全查询   不为空则具体查询
     * @return: IPage
     */
    IPage queryOrderByOrderNumber(Integer stationId, Integer current, String orderNumber);

    /**
     * @MethodName: queryUnDispatchOrder
     * @Description: DONE : 查询网点所有未指派派送员的订单
     * @Author: 30671
     * @date: 2022/7/18
     * @return: IPage
     */
    IPage queryUnDispatchOrder(Integer stationId,Integer current);
}
