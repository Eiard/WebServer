package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Employee;
import com.ytz.web.domain.Orders;
import com.ytz.web.mapper.OrdersMapper;
import com.ytz.web.model.OrdersEnum;
import com.ytz.web.service.OrdersService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.service.impl
 * @className: OrdersServiceImpl
 * @author: 30671
 * @description: TODO : 针对表【orders】的数据库操作Service实现
 * @date: 2022/7/5
 * @version: 1.0
 */
@Service("ordersServiceImpl")
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
        implements OrdersService {

    @Override
    public OrdersEnum dispatch(String orderNumber, Employee employee) {
        lambdaUpdate()
                .set(Orders::getOrderStatus, 2)
                .set(Orders::getSenderId, employee.getEmployeeId())
                .set(Orders::getSenderName, employee.getEmployeeName())
                .set(Orders::getSenderPhone, employee.getEmployeePhone())
                .eq(Orders::getOrderNumber, orderNumber)
                .update();
        return OrdersEnum.DISPATCH_SUCCESS;
    }

    @Override
    public OrdersEnum delivery(String orderNumber) {
        // 改为派送完
        lambdaUpdate().set(Orders::getOrderStatus, 3)
                .set(Orders::getIsDeleted, 1)
                .eq(Orders::getOrderNumber, orderNumber)
                .update();
        return OrdersEnum.DELIVERY_SUCCESS;
    }

    @Override
    public OrdersEnum received(String orderNumber) {
        lambdaUpdate().set(Orders::getOrderStatus, 1)
                .eq(Orders::getOrderNumber, orderNumber)
                .update();
        return OrdersEnum.RECEIVE_SUCCESS;
    }
}