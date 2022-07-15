package com.ytz.web.model;

/**
 * @projectName: web
 * @package: com.ytz.web.model
 * @className: OrdersEnum
 * @author: Delmore
 * @description: TODO : Orders状态码
 * @date: 2022/7/11 22:03
 * @version: 1.0
 */
public enum OrdersEnum {
    /**
     * 网点收件
     * 派送完成
     * 分配派送员完成
     */
    RECEIVE_SUCCESS,
    DISPATCH_SUCCESS,
    DELIVERY_SUCCESS,
    /**
     *
     * 创建订单成功
     * 获取订单价格
     *
     *
     *
     *
     *
     *
     **/
    CREATE_ORDER_SUCCESS,
    ACHIEVE_PRICE_SUCCESS,
}
