package com.ytz.web.controller;

import com.alibaba.fastjson.TypeReference;
import com.ytz.web.domain.Employee;
import com.ytz.web.domain.Orders;
import com.ytz.web.model.NetStationEnum;
import com.ytz.web.model.OrdersEnum;
import com.ytz.web.service.EmployeeService;
import com.ytz.web.service.NetStationService;
import com.ytz.web.service.OrdersService;
import com.ytz.web.utils.JsonUtils;
import com.ytz.web.utils.ResultMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    //快件管理
    @PostMapping("/fuzzyQueryByStationInfo")
    String fuzzyQueryByStationInfo(@RequestParam String stationInfo) {
        return new ResultMap(NetStationEnum.QUERY_SUCCESS, netStationService.fuzzyQueryByStationInfo(stationInfo)).toJson();
    }

    @PostMapping("/dispatch")
    String dispatch(@RequestParam String orderNumber, @RequestParam String employeeId) {
        Employee employee = employeeService.dispatch(employeeId);
        return new ResultMap(ordersService.dispatch(orderNumber, employee)).toJson();
    }

    @PostMapping("/createOrder")
    String createOrder(@RequestParam String orderAmount) {
        ResultMap resultMap = new ResultMap();
        resultMap.setEnum(ordersService.createOrder(JsonUtils.jsonToObject(orderAmount, new TypeReference<Orders>() {
        })));
        return resultMap.toJson();
    }

}
