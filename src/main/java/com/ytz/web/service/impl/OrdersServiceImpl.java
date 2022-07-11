package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Orders;
import com.ytz.web.service.OrdersService;
import com.ytz.web.mapper.OrdersMapper;
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
@Service
@Repository("ordersServiceImpl")
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




