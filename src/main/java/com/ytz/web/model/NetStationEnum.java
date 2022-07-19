package com.ytz.web.model;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.model
 * @className: NetStationEnum
 * @author: 30671
 * @description: TODO : NetStation状态码
 * @date: 2022/7/4
 * @version: 1.0
 */

public enum NetStationEnum {
    /**
     * 登录状态
     *      成功:
     *          网点管理员登录成功
     *      失败:
     *          账号或密码错误
     *          网点未激活
     */
    LOGIN_SUCCESS,
    LOGIN_FAILED,
    LOGIN_UNVERIFIED,
    LOGIN_UN_EMPLOYEE,

    /**
     * 注册网点(预注册后需要让系统管理员审核) 审核完后激活
     *      预注册成功:
     *          等待审核
     *      预注册失败:
     *          网点管理员账号已被使用
     *          网点管理员电话已被使用
     */
    PRE_SIGN_SUCCESS,
    PRE_SIGN_USERNAME_USED,
    PRE_SIGN_PHONE_USED,

    /**
     * 修改网点信息状态
     *      成功:
     *          信息修改成功
     *      失败:
     *          密码输入错误
     *          电话号码已被使用
     */
    CHANGE_SUCCESS,
    CHANCE_FAILED_PASSWORD_ERROR,
    CHANGE_FAILED_PHONE_USED,


    /**
     * 注销网点
     *      请求:
     *          让系统管理员来审核后系统管理员删除网点
     */
    LOGOFF_REQUEST,

    /**
     * 查询网点信息
     *      成功:
     *          查询成功
     *      失败:
     *          Id int 格式问题
     */
    QUERY_SUCCESS,

    /**
     * 未知错误
     * 格式错误
     */
    UNKNOWN_ERROR,
    FORMAT_ERROR,

    /**
     * 一个订单完成
     *
     */
    DELIVERY_SUCCESS,

    /**
     * 清空订单数成功
     */
    RESET_AMOUNT_SUCCESS;
}
