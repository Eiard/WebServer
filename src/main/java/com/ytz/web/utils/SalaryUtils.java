package com.ytz.web.utils;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.utils
 * @className: SalaryUtils
 * @author: 30671
 * @description: DONE : 根据员工类别 和 月处理订单数来计算工资
 * @date: 2022/7/14
 * @version: 1.0
 */

public class SalaryUtils {

    /**
     * 基本工资
     * 派送员
     * 网点管理员
     * 系统管理员
     */
    final static double employeeBaseSalary = 6000;
    final static double netStationBaseSalary = 8000;
    final static double rootBaseSalary = 16000;

    /**
     * 完成每单额外工资
     * 派送员每单
     * 网点管理员每单
     */
    final static double employeeSalaryPerOrder = 2;
    final static double netStationSalaryPerOrder = 0.8;

    /**
     * 定义变量pension为养老保险税
     * 定义变量medical为医疗保险税
     * 定义变量unEmploy为失业保险税
     * 定义变量housing为住房公积金税
     */
    final static double pensionTax = 0.08;
    final static double medicalTax = 0.02;
    final static double unEmployTax = 0.002;
    final static double housingTax = 0.12;


    /**
     * 个人所得税等级
     * Level                                     税
     * 0(money<5000):                            0
     * 1(5000 <= money < 8000):                  0.03
     * 2(8000 <= money < 17000):                 0.1
     * 3(17000 <= money <30000):                 0.2
     * 4(30000 <= money <40000):                 0.25
     * 5(40000 <= money <60000):                 0.3
     * 6(60000 <= money <80000):                 0.35
     * 6(80000 <= money):                        0.45
     */
    final static double personalTax0 = 0;
    final static double personalTax1 = 0.03;
    final static double personalTax2 = 0.1;
    final static double personalTax3 = 0.2;
    final static double personalTax4 = 0.25;
    final static double personalTax5 = 0.3;
    final static double personalTax6 = 0.35;
    final static double personalTax7 = 0.45;


    /**
     * 避免实例化
     */
    private SalaryUtils() {

    }

    /**
     * @MethodName: getBaseSalary
     * @Description: DONE : 获取员工的基本工资
     * @Author: 30671
     * @date: 2022/7/14
     * @param: type  员工类别
     * @return: Double
     */
    public Double getBaseSalary(Integer type) {
        if (type == 1) {
            return employeeBaseSalary;
        } else if (type == 2) {
            return netStationBaseSalary;
        } else if (type == 3) {
            return rootBaseSalary;
        }
        return 0.0;
    }

    /**
     * @MethodName: calculateSalary
     * @Description: DONE : 计算员工的总工资(算上处理的订单数量)
     * @Author: 30671
     * @date: 2022/7/14
     * @param: type  员工类别
     * @param: orderAmount  订单完成数量
     * @return: Double
     */
    public Double calculateSalary(Integer type, Integer orderAmount) {

        Double baseSalary = getBaseSalary(type);

        if (type == 1) {
            return baseSalary + orderAmount * employeeSalaryPerOrder;
        } else if (type == 2) {
            return baseSalary + orderAmount * netStationSalaryPerOrder;
        }

        return 0.0;
    }


    /**
     * @MethodName: taxDeduction
     * @Description: DONE : 扣税后的总工资
     * @Author: 30671
     * @date: 2022/7/14
     * @param: salary  包含订单派送个数 计算过后 的总工资
     * @return: Double
     */
    public Double taxDeduction(Double salary) {

        double pension = salary * pensionTax;
        double medical = salary * medicalTax;
        double unEmploy = salary * unEmployTax;
        double housing = salary * housingTax;

        // 扣除三险一金之后的工资(先扣)
        salary = salary - (pension + medical + unEmploy + housing);

        if (salary < 5000) {
            salary = salary - (salary) * personalTax0;
        } else if (salary >= 5000 && salary < 8000) {
            salary = salary - (salary - 5000) * personalTax1;
        } else if (salary >= 8000 && salary < 17000) {
            salary = salary - (salary - 8000) * personalTax2 - 3000 * personalTax1;
        } else if (salary >= 17000 && salary < 30000) {
            salary = salary - (salary - 17000) * personalTax3 - 9000 * personalTax2 - 3000 * personalTax1;
        } else if (salary >= 30000 && salary < 40000) {
            salary = salary - (salary - 30000) * personalTax4 - 13000 * personalTax3 - 9000 * personalTax2 - 3000 * personalTax1;
        } else if (salary >= 40000 && salary < 60000) {
            salary = salary - (salary - 40000) * personalTax5 - 10000 * personalTax4 - 13000 * personalTax3 - 9000 * personalTax2 - 3000 * personalTax1;
        } else if (salary >= 60000 && salary < 80000) {
            salary = salary - (salary - 60000) * personalTax6 - 20000 * personalTax5 - 10000 * personalTax4 - 13000 * personalTax3 - 9000 * personalTax2 - 3000 * personalTax1;
        } else if (salary >= 80000) {
            salary = salary - (salary - 80000) * personalTax7 - 25000 * personalTax6 - 20000 * personalTax5 - 10000 * personalTax4 - 13000 * personalTax3 - 9000 * personalTax2 - 3000 * personalTax1;
        }

        return salary;
    }

}
