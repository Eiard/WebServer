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


    /**
     * @param orderNumber 订单号List的Json
     * @param employee    包含员工Id 姓名 手机号
     * @description: DONE : 将多个订单号绑定员工
     */
    @PostMapping("/dispatch")
    String dispatch(@RequestParam String orderNumber, @RequestParam String employee) {

        return new ResultMap(
                ordersService.dispatch(
                        JsonUtils.jsonToList(orderNumber, new TypeReference<List<String>>() {
                        }),
                        JsonUtils.jsonToObject(employee, new TypeReference<Employee>() {
                        })
                )).toJson();
    }

    /**
     * @description: FIXME : 创建订单
     */
    @PostMapping("/createOrder")
    String createOrder(@RequestParam String orderAmount) {
        ResultMap resultMap = new ResultMap();
        resultMap.setEnum(ordersService.createOrder(JsonUtils.jsonToObject(orderAmount, new TypeReference<Orders>() {
        })));
        return resultMap.toJson();
    }

    /**
     * @param stationInfo 网点信息
     * @description: DONE : 模糊查询收件时的网点
     */
    @PostMapping("/fuzzyQueryByStationInfo")
    String fuzzyQueryByStationInfo(@RequestParam String stationInfo) {
        return new ResultMap(NetStationEnum.QUERY_SUCCESS
                , netStationService.fuzzyQueryByStationInfo(stationInfo))
                .toJson();
    }

    /**
     * @description: FIXME : 查询出在职员工信息(用于指派)
     */
    @GetMapping("/queryNetStationEmployee")
    String queryNetStationEmployee() {

        return new ResultMap(OrdersEnum.QUERY_SUCCESS, employeeService.queryNetStationEmployeeForDispatch(NeedChange.needChange)).toJson();
    }

    /**
     * @param current     页数
     * @param orderNumber 订单号
     * @description: FIXME : 查询订单信息
     */
    @PostMapping("/queryOrderByOrderNumber")
    String queryOrderByOrderNumber(@RequestParam Integer current, @RequestParam String orderNumber) {
        ResultMap resultMap = new ResultMap(OrdersEnum.QUERY_SUCCESS);

        // 通过session 拿到 netstation的信息
        IPage page = ordersService.queryOrderByOrderNumber(NeedChange.needChange, current, orderNumber);

        resultMap.setData(page.getRecords());
        resultMap.put("totalPage", page.getPages());

        return resultMap.toJson();
    }
    /**
     * @param current     页数
     * @description: DONE : 查询需要派送的订单
     */
    @GetMapping("/queryUnDispatchOrder")
    String queryUnDispatchOrder(@RequestParam Integer current) {
        ResultMap resultMap = new ResultMap();

        IPage page = ordersService.queryUnDispatchOrder(2, current);

        resultMap.setData(page.getRecords());
        resultMap.put("totalPage",page.getPages());

        return resultMap.toJson();
    }

}
