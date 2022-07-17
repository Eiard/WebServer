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
     * 成功:
     * 网点员工登陆成功
     * 失败:
     * 账号或密码错误
     * 员工未被审核
     */
    LOGIN_SUCCESS,
    LOGIN_FAILED,
    LOGIN_UNVERIFIED,


    /**
     * 注册员工(预注册后需要让系统管理员审核) 审核完后激活
     * 预注册成功:
     * 等待审核
     * 预注册失败:
     * 员工账号已被使用
     * 电话已被使用
     */
    PRE_SIGN_SUCCESS,
    PRE_SIGN_USERNAME_USED,
    PRE_SIGN_PHONE_USED,
    /**
     * 重置密码成功
     */
    RESET_PASSWORD_SUCCESS,

    /**
     * 派送成功
     */
    DELIVERY_SUCCESS,

    /**
     * 未知错误
     * 格式错误
     */
    UNKNOWN_ERROR,
    FORMAT_ERROR,

    /**
     *
     * 提交离职申请成功
     * 同意离职申请
     * 员工已离职
     */
    SUBMIT_RESIGNATION_SUCCESS,
    CONSENT_RESIGNATION_SUCCESS,
    IS_RESIGNED,

    /**
     * 清空订单数成功
     */
    RESET_AMOUNT_SUCCESS;

}
