package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Employee;
import com.ytz.web.domain.Orders;
import com.ytz.web.mapper.OrdersMapper;
import com.ytz.web.model.StatusEnum;
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
    public StatusEnum dispatch(List<String> orderNumberList, Employee employee) {
        for (String orderNumber : orderNumberList) {
            lambdaUpdate()
                    .set(Orders::getOrderStatus, 2)
                    .set(Orders::getSenderId, employee.getEmployeeId())
                    .set(Orders::getSenderName, employee.getEmployeeName())
                    .set(Orders::getSenderPhone, employee.getEmployeePhone())
                    .eq(Orders::getOrderNumber, orderNumber)
                    .update();
        }
        return StatusEnum.DISPATCH_SUCCESS;
    }

    @Override
    public StatusEnum delivery(String orderNumber) {
        // 改为派送完
        lambdaUpdate()
                .set(Orders::getOrderStatus, 3)
                .set(Orders::getIsDeleted, 1)
                .eq(Orders::getOrderNumber, orderNumber)
                .update();
        return StatusEnum.DELIVERY_SUCCESS;
    }

    @Override
    public StatusEnum createOrder(Orders order) {
        order.setOrderNumber(Long.toString(new IdGeneratorSnowflake().snowflakeId()));
        save(order);
        return StatusEnum.CREATE_ORDER_SUCCESS;
    }

    @Override
    public IPage queryOrderByOrderNumber(Integer stationId, Integer current, String orderNumber) {
        /**
         * 为空则全查询
         */
        if (orderNumber== null || orderNumber.equals("")) {
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

    @Override
    public IPage queryUnDispatchOrder(Integer stationId, Integer current) {

        return pageMaps(PageUtils.getOrdersPage(current),
                new LambdaQueryWrapper<Orders>()
                        .select(
                                Orders::getOrderNumber,
                                Orders::getConsignor,
                                Orders::getConsignorPhone,
                                Orders::getStartAddress,
                                Orders::getRecipient,
                                Orders::getRecipientPhone,
                                Orders::getRecipientAddress,
                                Orders::getCreateDate
                        )
                        .eq(Orders::getEndPoint, stationId)
                        .eq(Orders::getOrderStatus, 1));

    }


}