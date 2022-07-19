package com.ytz.web.model;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.model
 * @className: StatusEnum
 * @author: 30671
 * @description: DONE : 通信反馈状态码
 * @date: 2022/7/19
 * @version: 1.0
 */
public enum StatusEnum {
    /**
     * 登录状态
     *      网点员工登陆成功
     *      账号或密码错误
     *      员工未被审核
     *      员工已离职
     */
    LOGIN_SUCCESS,
    LOGIN_FAILED,
    LOGIN_UNVERIFIED,
    LOGIN_UN_VALID,


    /**
     * 预注册状态
     *      等待审核
     *      员工账号已被使用
     *      电话已被使用
     */
    PRE_SIGN_SUCCESS,
    PRE_SIGN_USERNAME_USED,
    PRE_SIGN_PHONE_USED,


    /**
     * 修改信息
     *      信息修改成功
     *      密码输入错误
     *      电话号码已被使用
     */
    CHANGE_SUCCESS,
    CHANCE_FAILED_PASSWORD_ERROR,
    CHANGE_FAILED_PHONE_USED,


    /**
     * 重置密码成功
     */
    RESET_PASSWORD_SUCCESS,


    /**
     * 提交离职申请成功
     * 同意离职申请
     * 员工已离职
     */
    SUBMIT_RESIGNATION_SUCCESS,
    CONSENT_RESIGNATION_SUCCESS,
    REFUSE_RESIGNATION_SUCCESS,

    /**
     * 派送成功
     */
    DELIVERY_SUCCESS,
    DELIVERY_FAILED,

    /**
     * 清空订单数成功
     */
    RESET_AMOUNT_SUCCESS,
    RESET_AMOUNT_FAILED,

    /**
     * 注销网点请求
     */
    LOGOFF_REQUEST,

    /**
     * 指派派送员完成
     * 工资派发成功
     * 工资派发失败
     */
    DISPATCH_SUCCESS,
    PAY_SALARY_SUCCESS,
    PAY_SALARY_FAILED,

    /**
     * 获取价格成功
     */
    GET_PRICE_SUCCESS,

    /**
     * 创建订单成功
     **/
    CREATE_ORDER_SUCCESS,

    /**
     * 查询成功
     */
    QUERY_SUCCESS,

    /**
     * 格式错误
     * 未知错误
     */
    FORMAT_ERROR,
    UNKNOWN_ERROR,
}
