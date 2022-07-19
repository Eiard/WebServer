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


    @RequestMapping("/login")
    String login(@RequestParam String employeeUsername
            , @RequestParam String employeePassword
            , HttpSession session) {
        ResultMap resultMap = new ResultMap();

        Employee employee = employeeService.login(employeeUsername, employeePassword);

        if (employee == null) {
            resultMap.setEnum(EmployeeEnum.LOGIN_FAILED);
        } else if (employee.getIsPass() == 0) {
            resultMap.setEnum(EmployeeEnum.LOGIN_UNVERIFIED);
        } else {
            resultMap.setEnum(EmployeeEnum.LOGIN_SUCCESS);

            String token = TokenUtil.makeToken(employee.getEmployeeType());

            session.setAttribute(token, employee.getEmployeeId());

            resultMap.setToken(token);
        }

        return resultMap.toJson();
    }

    @RequestMapping("/sign")
    String sign(@RequestParam String employee) {
        ResultMap resultMap = new ResultMap();
        try {
            resultMap.setEnum(employeeService.sign(JsonUtils.jsonToObject(employee, new TypeReference<Employee>() {
            })));
        } catch (Exception e) {
            resultMap.setEnum(EmployeeEnum.FORMAT_ERROR);
        }
        return resultMap.toJson();
    }

    @RequestMapping("/delivery")
    String delivery(@RequestParam String employeeUsername, @RequestParam String orderNumber) {

        // 派送员送件数增加
        Integer stationId = employeeService.delivery(employeeUsername);

        // 网点送件数增加
        netStationService.delivery(stationId);

        // 订单状态更改
        ordersService.delivery(orderNumber);

        return new ResultMap(EmployeeEnum.DELIVERY_SUCCESS).toJson();
    }

    @PostMapping("/submitResignation")
    String resign(@RequestParam String resignReason, @RequestParam String employeeUsername) {
        return new ResultMap(employeeService.submitResignation(resignReason, employeeUsername)).toJson();
    }

    /**
     * @param current
     * @param request
     * @return
     * @description: DONE : 查询在职员工
     */
    @PostMapping("/queryInEmployee")
    String queryInEmployee(@RequestParam Integer current,
                           HttpServletRequest request) {

        IPage page = employeeService.queryInEmployee(current, TokenUtil.getId(request));

        ResultMap resultMap = new ResultMap(NetStationEnum.QUERY_SUCCESS, page.getRecords());

        resultMap.put("totalPage", page.getPages());
        return resultMap.toJson();
    }

    /**
     * @param current
     * @param request
     * @description: DONE : 员工操作查询准备离职的员工
     */
    @PostMapping("/queryOutEmployee")
    String queryOutEmployee(@RequestParam Integer current,
                            HttpServletRequest request) {

        IPage page = employeeService.queryOutEmployee(current, TokenUtil.getId(request));

        ResultMap resultMap = new ResultMap(NetStationEnum.QUERY_SUCCESS, page.getRecords());

        resultMap.put("totalPage", page.getPages());
        return resultMap.toJson();
    }

    /**
     * @param employeeIdList 员工Id的List Json
     * @description: DONE : 重置员工密码
     */
    @PostMapping("/resetPassword")
    String resetPassword(@RequestParam String employeeIdList) {
        return new ResultMap(employeeService.resetPassword(JsonUtils.jsonToList(employeeIdList, new TypeReference<List<Integer>>() {
        }))).toJson();
    }

    @PostMapping("/consentResignation")
    String consentResignation(@RequestParam String employeeUsername) {
        return new ResultMap(employeeService.consentResignation(employeeUsername)).toJson();
    }
}