package com.ytz.web.service;

import com.ytz.web.domain.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
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

    OrdersEnum delivery(String orderNumber);

}
