package com.ytz.web.model;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.model
 * @className: EmployeeEnum
 * @author: 30671
 * @description: TODO : Employee状态码
 * @date: 2022/7/5
 * @version: 1.0
 */

public enum EmployeeEnum {
    /**
     * 登录状态
     *      成功:
     *          网点员工登陆成功
     *      失败:
     *          账号或密码错误
     *          员工未被审核
     */
    LOGIN_SUCCESS,
    LOGIN_FAILED,
    LOGIN_UNVERIFIED,


}
