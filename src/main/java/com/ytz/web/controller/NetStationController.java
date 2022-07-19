package com.ytz.web.controller;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ytz.web.domain.Employee;
import com.ytz.web.domain.NetStation;
import com.ytz.web.domain.Orders;
import com.ytz.web.model.StatusEnum;
import com.ytz.web.service.EmployeeService;
import com.ytz.web.service.FinanceService;
import com.ytz.web.service.NetStationService;
import com.ytz.web.service.OrdersService;
import com.ytz.web.utils.JsonUtils;
import com.ytz.web.utils.ResultMap;
import com.ytz.web.utils.TokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.controller
 * @className: NetStationController
 * @author: 30671
 * @description: TODO : 管理员操作
 * @date: 2022/7/4
 * @version: 1.0
 */
@RestController
@RequestMapping("/netStation")
public class NetStationController {

    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;

    @Resource(name = "netStationServiceImpl")
    private NetStationService netStationService;

    @Resource(name = "ordersServiceImpl")
    private OrdersService ordersService;

    @Resource(name = "financeServiceImpl")
    private FinanceService financeService;

    /**
     * @MethodName: login
     * @Description: DONE : 实现网点管理员登录
     * @Author: 30671
     * @date: 2022/7/5
     * @param: adminUsername  账号
     * @param: adminPassword  密码
     * @param: session        会议
     * @return: String
     */
    @PostMapping("/login")
    String login(@RequestParam String adminUsername,
                 @RequestParam String adminPassword,
                 HttpSession session) {
        ResultMap resultMap = new ResultMap();

        NetStation netStation = netStationService.login(adminUsername, adminPassword);

        if (netStation == null) {
            resultMap.setEnum(StatusEnum.LOGIN_FAILED);
        } else if (netStation.getIsPass() == 0) {
            resultMap.setEnum(StatusEnum.LOGIN_UNVERIFIED);
        } else if (netStation.getIsPass() == 3) {
            resultMap.setEnum(StatusEnum.LOGIN_UN_VALID);
        } else {
            resultMap.setEnum(StatusEnum.LOGIN_SUCCESS);

            // 根据类别生成token
            String token = TokenUtil.makeToken(netStation.getAdminType());

            // 存stationId
            session.setAttribute(token, netStation.getStationId());

            resultMap.setToken(token);
        }
        return resultMap.toJson();
    }

    /**
     * @MethodName: sign
     * @Description: DONE : 实现网点预注册
     * @Author: 30671
     * @date: 2022/7/5
     * @param: netStation  网点的对象Json
     * @return: String
     */
    @PostMapping("/sign")
    String sign(@RequestParam String netStation) {
        ResultMap resultMap = new ResultMap();
        try {
            resultMap.setEnum(netStationService.sign(JsonUtils.jsonToObject(netStation, new TypeReference<NetStation>() {
            })));
        } catch (Exception e) {
            resultMap.setEnum(StatusEnum.FORMAT_ERROR);
        }
        return resultMap.toJson();
    }

    /**
     * @MethodName: queryStationVoById
     * @Description: DONE : 查询网点个人信息
     * @Author: 30671
     * @date: 2022/7/19
     * @param: request  请求
     * @return: String
     */
    @PostMapping("/queryStationVoById")
    String queryStationVoById(HttpServletRequest request) {

        return new ResultMap(
                StatusEnum.QUERY_SUCCESS,
                netStationService.queryStationVoById(TokenUtil.getId(request)))
                .toJson();
    }

    /**
     * @MethodName: updateStationInform
     * @Description: DONE : 更新网点个人信息
     * @Author: 30671
     * @date: 2022/7/5
     * @param: netStation  网点信息的对象Json
     * @param: newPassword 新密码
     * @return: String
     */
    @PostMapping("/updateStationInform")
    String updateStationInform(@RequestParam String netStation,
                               @RequestParam String newPassword) {

        ResultMap resultMap = new ResultMap();
        try {
            resultMap.setEnum
                    (netStationService.updateStationInform(
                            JsonUtils.jsonToObject(netStation, new TypeReference<NetStation>() {
                            }),
                            newPassword));
        } catch (Exception e) {
            resultMap.setEnum(StatusEnum.FORMAT_ERROR);
        }
        return resultMap.toJson();
    }


    /**
     * @MethodName: queryActiveEmployee
     * @Description: DONE : 查询在职员工信息
     * @Author: 30671
     * @date: 2022/7/4
     * @param: current  页数
     * @param: request  请求
     * @return: String
     */
    @PostMapping("/queryActiveEmployee")
    String queryActiveEmployee(@RequestParam Integer current,
                               HttpServletRequest request) {

        IPage page = employeeService.queryActiveEmployeeVo(current, TokenUtil.getId(request));

        ResultMap resultMap = new ResultMap(StatusEnum.QUERY_SUCCESS, page.getRecords());

        resultMap.put("totalPage", page.getPages());
        return resultMap.toJson();
    }

    /**
     * @MethodName: queryPreResignationEmployeeVo
     * @Description: DONE : 查询预离职的员工信息(已经提交离职申请的员工)
     * @Author: 30671
     * @date: 2022/7/6
     * @param: current  页数
     * @param: request  请求
     * @return: String
     */
    @PostMapping("/queryPreResignationEmployeeVo")
    String queryPreResignationEmployeeVo(@RequestParam Integer current,
                                         HttpServletRequest request) {

        IPage page = employeeService.queryPreResignationEmployeeVo(current, TokenUtil.getId(request));

        ResultMap resultMap = new ResultMap(StatusEnum.QUERY_SUCCESS, page.getRecords());

        resultMap.put("totalPage", page.getPages());
        return resultMap.toJson();
    }

    /**
     * @MethodName: resetPassword
     * @Description: DONE : 重置派送员密码
     * @Author: 30671
     * @date: 2022/7/13
     * @param: employeeIdList  派送员Id的List
     * @return: String
     */
    @PostMapping("/resetPassword")
    String resetPassword(@RequestParam String employeeIdList) {
        return new ResultMap(employeeService.resetPassword(JsonUtils.jsonToList(employeeIdList, new TypeReference<List<Integer>>() {
        }))).toJson();
    }

    /**
     * @MethodName: consentResignation
     * @Description: DONE : 审批是否同意派送员离职
     * @Author: 30671
     * @date: 2022/7/13
     * @param: employeeIdList  派送员Id的List
     * @return: String
     */
    @PostMapping("/consentResignation")
    String consentResignation(@RequestParam String employeeIdList, @RequestParam Integer permit) {
        return new ResultMap(
                employeeService.consentResignation(
                        JsonUtils.jsonToList(employeeIdList, new TypeReference<List<Integer>>() {
                        }),
                        permit)).toJson();
    }

    /**
     * @MethodName: addEmployee
     * @Description: DONE : 网点管理员添加一个派送员
     * @Author: 30671
     * @date: 2022/7/13
     * @param: employee  派送员的信息
     * @param: request   请求
     * @return: String
     */
    @RequestMapping("/addEmployee")
    String addEmployee(@RequestParam String employee,
                       HttpServletRequest request) {
        ResultMap resultMap = new ResultMap();

        try {
            Employee employeeObj = JsonUtils.jsonToObject(employee, new TypeReference<Employee>() {
            });

            employeeObj.setStationId(TokenUtil.getId(request));

            resultMap.setEnum(employeeService.addEmployee(employeeObj));

        } catch (Exception e) {
            resultMap.setEnum(StatusEnum.FORMAT_ERROR);
        }
        return resultMap.toJson();
    }

    /**
     * @MethodName: dispatch
     * @Description: DONE : 将多个订单号绑定员工
     * @Author: 30671
     * @date: 2022/7/13
     * @param: orderNumber 订单号List的Json
     * @param: employee 包含员工Id 姓名 手机号
     * @return: String
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
     * @MethodName: fuzzyQueryByStationVo
     * @Description: DONE : 模糊查询收件网点信息
     * @Author: Delmore
     * @date: 2022/7/13
     * @param: stationInfo 模糊查询的字段
     * @return: String
     */
    @PostMapping("/fuzzyQueryByStationVo")
    String fuzzyQueryByStationVo(@RequestParam String stationInfo) {
        return new ResultMap(StatusEnum.QUERY_SUCCESS
                , netStationService.fuzzyQueryByStationVo(stationInfo))
                .toJson();
    }

    /**
     * @MethodName: createOrder
     * @Description: DONE : 创建一个订单
     * @Author: Delmore
     * @date: 2022/7/13
     * @param: stationInfo 模糊查询的字段
     * @param: orderJson 订单的Json
     * @param: request   请求
     * @return: String
     */
    @PostMapping("/createOrder")
    String createOrder(@RequestParam String orderJson,
                       HttpServletRequest request) {

        ResultMap resultMap = new ResultMap();

        Orders order;
        try {

            order = JsonUtils.jsonToObject(orderJson, new TypeReference<Orders>() {
            });

            NetStation netStation = netStationService.queryStationById(TokenUtil.getId(request));

            order.setStartPoint(netStation.getStationId());
            order.setStartAddress(netStation.getStationAddress());

            resultMap.setEnum(ordersService.createOrder(order));

        } catch (Exception e) {

            resultMap.setEnum(StatusEnum.FORMAT_ERROR);
        }
        return resultMap.toJson();
    }

    /**
     * @MethodName: queryOrderByOrderNumber
     * @Description: DONE : 查询订单Vo
     * @Author: Delmore
     * @date: 2022/7/13
     * @param: current       页数
     * @param: orderNumber   具体订单号或者为空
     * @param: request       请求
     * @return: String
     */
    @PostMapping("/queryOrderByOrderNumber")
    String queryOrderByOrderNumber(@RequestParam Integer current,
                                   @RequestParam String orderNumber,
                                   HttpServletRequest request) {
        ResultMap resultMap = new ResultMap(StatusEnum.QUERY_SUCCESS);

        IPage page = ordersService.queryOrderByOrderNumber(TokenUtil.getId(request), current, orderNumber);

        resultMap.setData(page.getRecords());
        resultMap.put("totalPage", page.getPages());
        return resultMap.toJson();
    }


    /**
     * @MethodName: queryActiveEmployeeDispatch
     * @Description: DONE : 查询出在职员工信息(用于指派) (和发工资)
     * @Author: 30671
     * @date: 2022/7/13
     * @param: request       请求
     * @return: String
     */
    @PostMapping("/queryActiveEmployeeDispatch")
    String queryActiveEmployeeDispatch(HttpServletRequest request) {
        return new ResultMap(StatusEnum.QUERY_SUCCESS, employeeService.queryActiveEmployee(TokenUtil.getId(request))).toJson();
    }


    /**
     * @MethodName: queryActiveEmployeeDispatch
     * @Description: DONE : 查询需要指派的订单
     * @Author: 30671
     * @date: 2022/7/13
     * @param: current       页数
     * @param: request       请求
     * @return: String
     */
    @PostMapping("/queryUnDispatchOrder")
    String queryUnDispatchOrder(@RequestParam Integer current,
                                HttpServletRequest request) {
        ResultMap resultMap = new ResultMap(StatusEnum.QUERY_SUCCESS);
        IPage page = ordersService.queryUnDispatchOrder(TokenUtil.getId(request), current);
        resultMap.setData(page.getRecords());
        resultMap.put("totalPage", page.getPages());
        return resultMap.toJson();
    }

    /**
     * @MethodName: querySalary
     * @Description: DONE ：查询工资记录
     * @Author: Delmore
     * @date: 2022/7/19
     * @param: request
     * @return: java.lang.String
     **/
    @PostMapping("querySalary")
    String querySalary(@RequestParam Integer current,
                       HttpServletRequest request) {
        ResultMap resultMap = new ResultMap();
        NetStation netStation = netStationService.getById(TokenUtil.getId(request));
        IPage page = financeService.querySalary(netStation.getStationId(), netStation.getAdminType(),current);
        resultMap.setData(page.getRecords());
        resultMap.put("totalPage", page.getPages());
        resultMap.setEnum(StatusEnum.QUERY_SUCCESS);
        return resultMap.toJson();
    }
}