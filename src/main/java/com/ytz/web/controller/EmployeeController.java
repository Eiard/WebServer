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

    /**
     * @MethodName: login
     * @Description: DONE : 员工登录
     * @Author: 30671
     * @date: 2022/7/5
     * @param: employeeUsername 员工姓名
     * @param: employeePassword  员工密码
     * @param: session          会话
     * @return: String
     */
    @PostMapping("/login")
    String login(@RequestParam String employeeUsername,
                 @RequestParam String employeePassword,
                 HttpSession session) {
        ResultMap resultMap = new ResultMap();
        Employee employee = employeeService.login(employeeUsername, employeePassword);

        if (employee == null) {
            resultMap.setEnum(EmployeeEnum.LOGIN_FAILED);
        } else if (employee.getIsPass() == 0) {
            resultMap.setEnum(EmployeeEnum.LOGIN_UNVERIFIED);
        } else {
            String token = TokenUtil.makeToken(employee.getEmployeeType());
            session.setAttribute(token,employee.getEmployeeId());
            resultMap.setToken(token);
            resultMap.setEnum(EmployeeEnum.LOGIN_SUCCESS);
        }
        return resultMap.toJson();
    }


    /**
     * @MethodName: delivery
     * @Description: DONE ：派送成功，订单完成，员工与网点订单数加一
     * @Author: Delmore
     * @date: 2022/7/19
     * @param: employeeUsername
     * @param: orderNumber
     * @return: java.lang.String
     **/
    @PostMapping("/delivery")
    String delivery(@RequestParam String orderNumber,
                    HttpServletRequest request) {

        // 派送员送件数增加
        Integer stationId = employeeService.delivery(TokenUtil.getId(request));

        // 网点送件数增加
        netStationService.delivery(stationId);

        // 订单状态更改
        ordersService.delivery(orderNumber);

        return new ResultMap(EmployeeEnum.DELIVERY_SUCCESS).toJson();
    }


    /**
     * @MethodName: submitResignation
     * @Description: DONE : 提交申请
     * @Author: 30671
     * @date: 2022/7/5
     * @param: resignReason  离职缘由
     * @param: employeeUsername 员工姓名
     * @return: String
     */
    @PostMapping("/submitResignation")
    String submitResignation(@RequestParam String resignReason,
                             HttpServletRequest request) {
        return new ResultMap(employeeService.submitResignation(resignReason, TokenUtil.getId(request))).toJson();
    }
}