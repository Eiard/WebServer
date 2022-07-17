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

    @PostMapping("/queryOrderByOrderNumber")
    String queryOrderByOrderNumber(@RequestParam Integer current, @RequestParam String orderNumber) {
        ResultMap resultMap = new ResultMap(OrdersEnum.QUERY_SUCCESS);

        // 通过session 拿到 netstation的信息
        IPage page = ordersService.queryOrderByOrderNumber(NeedChange.needChange, current, orderNumber);

        resultMap.setData(page.getRecords());
        resultMap.put("totalPage", page.getPages());

        return resultMap.toJson();
    }

    @GetMapping("/queryNetStationEmployee")
    String queryNetStationEmployee() {
        ResultMap resultMap = new ResultMap(OrdersEnum.QUERY_SUCCESS);

        resultMap.setData(employeeService.queryInEmployee(NeedChange.needChange));

        return resultMap.toJson();
    }

}
