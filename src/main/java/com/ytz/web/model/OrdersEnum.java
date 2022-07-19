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
     * 派送完成
     * 分配派送员完成
     */
    DISPATCH_SUCCESS,
    DELIVERY_SUCCESS,
    /**
     * 创建订单成功
     **/
    CREATE_ORDER_SUCCESS,

    /**
     * 查询成功
     */
    QUERY_SUCCESS,

    /**
     * Json格式错误
     */
    FORMAT_ERROR,
}
