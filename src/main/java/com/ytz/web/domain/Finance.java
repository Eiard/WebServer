package com.ytz.web.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.domain
 * @className: Finance
 * @author: 30671
 * @description: DONE : 工资
 * @date: 2022/7/4
 * @TableName finance
 * @version: 1.0
 */
@TableName(value ="finance")
@Data
public class Finance implements Serializable {
    /**
     * 员工ID
     */
    @TableField(value = "employee_id")
    private Integer employeeId;

    /**
     * 员工姓名
     */
    @TableField(value = "employee_name")
    private String employeeName;

    /**
     * 员工薪水(税前)
     */
    @TableField(value = "salary")
    private Double salary;

    /**
     * 快递单数
     */
    @TableField(value = "order_amount")
    private Integer orderAmount;

    /**
     * 员工总工资(税后)
     */
    @TableField(value = "total_salary")
    private Double totalSalary;

    /**
     * 薪水创建日期(创建后不再更改)
     */
    @TableField(value = "create_date")
    private LocalDateTime createDate;

    /**
     * 薪水更新日期
     */
    @TableField(value = "update_date")
    private LocalDateTime updateDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Finance other = (Finance) that;
        return (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getEmployeeName() == null ? other.getEmployeeName() == null : this.getEmployeeName().equals(other.getEmployeeName()))
            && (this.getSalary() == null ? other.getSalary() == null : this.getSalary().equals(other.getSalary()))
            && (this.getOrderAmount() == null ? other.getOrderAmount() == null : this.getOrderAmount().equals(other.getOrderAmount()))
            && (this.getTotalSalary() == null ? other.getTotalSalary() == null : this.getTotalSalary().equals(other.getTotalSalary()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getEmployeeName() == null) ? 0 : getEmployeeName().hashCode());
        result = prime * result + ((getSalary() == null) ? 0 : getSalary().hashCode());
        result = prime * result + ((getOrderAmount() == null) ? 0 : getOrderAmount().hashCode());
        result = prime * result + ((getTotalSalary() == null) ? 0 : getTotalSalary().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeId=").append(employeeId);
        sb.append(", employeeName=").append(employeeName);
        sb.append(", salary=").append(salary);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", totalSalary=").append(totalSalary);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}