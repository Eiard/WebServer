package com.ytz.web.controller;

import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ytz.web.domain.Employee;
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

    @Resource(name = "financeServiceImpl")
    private FinanceService financeService;

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
            resultMap.setEnum(StatusEnum.LOGIN_FAILED);
        } else if (employee.getIsPass() == 0) {
            resultMap.setEnum(StatusEnum.LOGIN_UNVERIFIED);
        } else if (employee.getIsPass() == 3) {
            resultMap.setEnum(StatusEnum.LOGIN_UN_VALID);
        } else {
            String token = TokenUtil.makeToken(employee.getEmployeeType());
            session.setAttribute(token, employee.getEmployeeId());
            resultMap.setToken(token);
            resultMap.setEnum(StatusEnum.LOGIN_SUCCESS);
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

        return new ResultMap(StatusEnum.DELIVERY_SUCCESS).toJson();
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
        Employee employee = employeeService.getById(TokenUtil.getId(request));
        IPage page = financeService.querySalary(employee.getEmployeeId(), employee.getEmployeeType(), current);
        resultMap.setData(page.getRecords());
        resultMap.put("totalPage", page.getPages());
        resultMap.setEnum(StatusEnum.QUERY_SUCCESS);
        return resultMap.toJson();
    }

    /**
     * @MethodName: updateEmployeeInform
     * @Description: DONE ：修改个人信息
     * @Author: Delmore
     * @date: 2022/7/19
     * @param: employee 员工信息
     * @param: newPassword 新密码
     * @return: java.lang.String
     **/
    @PostMapping("/updateEmployeeInform")
    String updateEmployeeInform(@RequestParam String employee,
                                @RequestParam String newPassword){
        ResultMap resultMap = new ResultMap();
        try {
            resultMap.setEnum
                    (employeeService.updateEmployeeInform(
                            JsonUtils.jsonToObject(employee, new TypeReference<Employee>() {
                            }),
                            newPassword));
        } catch (Exception e) {
            resultMap.setEnum(StatusEnum.FORMAT_ERROR);
        }
        return resultMap.toJson();
    }
    /**
     * @MethodName: queryEmployeeVoById
     * @Description: DONE ： 查询员工个人信息
     * @Author: Delmore
     * @date: 2022/7/19
     * @param: request 请求
     * @return: java.lang.String
     **/
    @PostMapping("/queryEmployeeVoById")
    String queryEmployeeVoById(HttpServletRequest request){
        return new ResultMap(
                StatusEnum.QUERY_SUCCESS,
                employeeService.queryEmployeeVoById(TokenUtil.getId(request)))
                .toJson();
    }
    /**
     * @MethodName: queryOrderByEmployId
     * @Description:  DONE : 查询员工信息
     * @Author: Delmore
     * @date: 2022/7/19
     * @param: current 页数
     * @param: request 请求
     * @return: java.lang.String
     **/
    @PostMapping("/queryOrderByEmployId")
    String queryOrderByEmployId(@RequestParam Integer current,
                                HttpServletRequest request){
        ResultMap resultMap = new ResultMap();
        IPage page = ordersService.queryOrderByEmployId(TokenUtil.getId(request),current);
        resultMap.setData(page.getRecords());
        resultMap.put("totalPage", page.getPages());
        return resultMap.toJson();
    }

}