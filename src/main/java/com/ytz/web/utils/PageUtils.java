package com.ytz.web.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * @projectName: web
 * @package: com.ytz.web.utils
 * @className: PageUtils
 * @author: 30671
 * @description: DONE : 获取分页对象
 * @date: 2022/7/13 10:59
 * @version: 1.0
 */
public class PageUtils {

    public final static int GOOD_TYPE_PAGE_SIZE = 10;
    public final static int FINANCE_PAGE_SIZE = 10;
    public final static int ORDERS_PAGE_SIZE = 10;

    public final static int USER_PAGE_SIZE = 10;
    public final static int EMPLOYEE_PAGE_SIZE = 10;
    public final static int NET_STATION_PAGE_SIZE = 10;
    public final static int ROOT_PAGE_SIZE = 10;


    public static IPage getGoodTypePage(int current) {
        return new Page(current, GOOD_TYPE_PAGE_SIZE);
    }

    public static IPage getFinancePage(int current) {
        return new Page(current, FINANCE_PAGE_SIZE);
    }

    public static IPage getOrdersPage(int current) {
        return new Page(current, ORDERS_PAGE_SIZE);
    }

    public static IPage getUserPage(int current) {
        return new Page(current, USER_PAGE_SIZE);
    }

    public static IPage getEmployeePage(int current) {
        return new Page(current, EMPLOYEE_PAGE_SIZE);
    }

    public static IPage getNetStationPage(int current) {
        return new Page(current, NET_STATION_PAGE_SIZE);
    }

    public static IPage getRootPage(int current) {
        return new Page(current, ROOT_PAGE_SIZE);
    }


}
