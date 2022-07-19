package com.ytz.web.controller;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ytz.web.domain.Employee;
import com.ytz.web.model.EmployeeEnum;
import com.ytz.web.model.NetStationEnum;
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
import java.util.List;

/**
 * @projectName: web
 * @package: com.ytz.web.controller
 * @className: EmployeeController
 * @author: Delmore
 * @description: TODO : 员工操作
 * @date: 2022/7/7 12:34
 * @version: 1.0
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;

    @Resource(name = "netStationServiceImpl")
    private NetStationService netStationService;

    @Resource(name = "ordersServiceImpl")
    private OrdersService ordersService;


    // @RequestMapping("/login")
    // String login(@RequestParam String employeeUsername, @RequestParam String employeePassword) {
    //     return new ResultMap(employeeService.login(employeeUsername, employeePassword)).toJson();
    // }
    //
    //
    // @RequestMapping("/delivery")
    // String delivery(@RequestParam String employeeUsername, @RequestParam String orderNumber) {
    //
    //     // 派送员送件数增加
    //     Integer stationId = employeeService.delivery(employeeUsername);
    //
    //     // 网点送件数增加
    //     netStationService.delivery(stationId);
    //
    //     // 订单状态更改
    //     ordersService.delivery(orderNumber);
    //
    //     return new ResultMap(EmployeeEnum.DELIVERY_SUCCESS).toJson();
    // }

    /**
     * 提交申请
     */

    // @PostMapping("/submitResignation")
    // String resign(@RequestParam String resignReason, @RequestParam String employeeUsername) {
    //     return new ResultMap(employeeService.submitResignation(resignReason, employeeUsername)).toJson();
    // }
    //
}