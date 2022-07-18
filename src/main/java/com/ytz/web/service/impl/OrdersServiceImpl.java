package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Employee;
import com.ytz.web.domain.Orders;
import com.ytz.web.mapper.OrdersMapper;
import com.ytz.web.model.OrdersEnum;
import com.ytz.web.service.OrdersService;
import com.ytz.web.utils.IdGeneratorSnowflake;
import com.ytz.web.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public OrdersEnum dispatch(List<String> orderNumberList, Employee employee) {
        for (String orderNumber : orderNumberList) {
            lambdaUpdate()
                    .set(Orders::getOrderStatus, 2)
                    .set(Orders::getSenderId, employee.getEmployeeId())
                    .set(Orders::getSenderName, employee.getEmployeeName())
                    .set(Orders::getSenderPhone, employee.getEmployeePhone())
                    .eq(Orders::getOrderNumber, orderNumber)
                    .update();
        }
        return OrdersEnum.DISPATCH_SUCCESS;
    }

    @Override
    public OrdersEnum delivery(String orderNumber) {
        // 改为派送完
        lambdaUpdate()
                .set(Orders::getOrderStatus, 3)
                .set(Orders::getIsDeleted, 1)
                .eq(Orders::getOrderNumber, orderNumber)
                .update();
        return OrdersEnum.DELIVERY_SUCCESS;
    }

    @Override
    public OrdersEnum createOrder(Orders orderAmount) {
        orderAmount.setOrderNumber(Long.toString(new IdGeneratorSnowflake().snowflakeId()));
        save(orderAmount);
        return OrdersEnum.CREATE_ORDER_SUCCESS;
    }

    @Override
    public IPage queryOrderByOrderNumber(Integer stationId, Integer current, String orderNumber) {

        /**
         * 为空则全查询
         */
        if (orderNumber.equals("")) {
            return pageMaps(PageUtils.getOrdersPage(current),
                    new LambdaQueryWrapper<Orders>()
                            .eq(Orders::getStartPoint, stationId)
                            .or(ordersLambdaQueryWrapper -> ordersLambdaQueryWrapper
                                    .eq(Orders::getEndPoint, stationId)
                            )
            );
        }

        /**
         * 不为空咋查询具体订单号
         */
        return pageMaps(PageUtils.getOrdersPage(current),
                new LambdaQueryWrapper<Orders>()
                        .eq(Orders::getStartPoint, stationId)
                        .or(ordersLambdaQueryWrapper -> ordersLambdaQueryWrapper
                                .eq(Orders::getEndPoint, stationId)
                        )
                        .eq(Orders::getOrderNumber, orderNumber)
        );
    }

}