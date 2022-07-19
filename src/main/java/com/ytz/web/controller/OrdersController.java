package com.ytz.web.controller;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ytz.web.NeedChange;
import com.ytz.web.domain.Employee;
import com.ytz.web.domain.Orders;
import com.ytz.web.model.NetStationEnum;
import com.ytz.web.model.OrdersEnum;
import com.ytz.web.service.EmployeeService;
import com.ytz.web.service.NetStationService;
import com.ytz.web.service.OrdersService;
import com.ytz.web.utils.JsonUtils;
import com.ytz.web.utils.ResultMap;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @projectName: web
 * @package: com.ytz.web.controller
 * @className: OrderController
 * @author: Delmore
 * @description: TODO
 * @date: 2022/7/14 15:55
 * @version: 1.0
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Resource(name = "netStationServiceImpl")
    private NetStationService netStationService;

    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;

    @Resource(name = "ordersServiceImpl")
    private OrdersService ordersService;


}