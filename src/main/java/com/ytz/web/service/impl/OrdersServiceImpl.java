package com.ytz.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytz.web.domain.Orders;
import com.ytz.web.service.OrdersService;
import com.ytz.web.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author 30671
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2022-07-04 20:06:47
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




