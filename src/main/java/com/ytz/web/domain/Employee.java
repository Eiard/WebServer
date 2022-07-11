package com.ytz.web.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.domain
 * @className: Employee
 * @author: 30671
 * @description: DONE : 员工
 * @date: 2022/7/4
 * @TableName employee
 * @version: 1.0
 */
@TableName(value ="employee")
@Data
public class Employee implements Serializable {
    /**
     * 员工工号
     */
    @TableId(value = "employee_id", type = IdType.AUTO)
    private Integer employeeId;

    /**
     * 员工姓名
     */
    @TableField(value = "employee_name")
    private String employeeName;

    /**
     * 员工账号
     */
    @TableField(value = "employee_username")
    private String employeeUsername;

    /**
     * 员工密码
     */
    @TableField(value = "employee_password")
    private String employeePassword;

    /**
     * 员工性别 0 女 1 男
     */
    @TableField(value = "employee_sex")
    private Boolean employeeSex;

    /**
     * 员工电话
     */
    @TableField(value = "employee_phone")
    private String employeePhone;

    /**
     * 所属网点ID(自动)
     */
    @TableField(value = "station_id")
    private Integer stationId;

    /**
     * 员工类型ID
     */
    @TableField(value = "employee_type")
    private Boolean employeeType;

    /**
     * 状态标志位 [0] 未审核或离职 [1] 审核通过并在职
     */
    @TableField(value = "is_pass")
    private Integer isPass;

    /**
     * 辞职理由
     */
    @TableField(value = "resign_reason")
    private String resignReason;

    /**
     * 创建日期
     */
    @TableField(value = "create_date")
    private LocalDateTime createDate;

    /**
     *  更新日期
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
        Employee other = (Employee) that;
        return (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getEmployeeName() == null ? other.getEmployeeName() == null : this.getEmployeeName().equals(other.getEmployeeName()))
            && (this.getEmployeeUsername() == null ? other.getEmployeeUsername() == null : this.getEmployeeUsername().equals(other.getEmployeeUsername()))
            && (this.getEmployeePassword() == null ? other.getEmployeePassword() == null : this.getEmployeePassword().equals(other.getEmployeePassword()))
            && (this.getEmployeeSex() == null ? other.getEmployeeSex() == null : this.getEmployeeSex().equals(other.getEmployeeSex()))
            && (this.getEmployeePhone() == null ? other.getEmployeePhone() == null : this.getEmployeePhone().equals(other.getEmployeePhone()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getEmployeeType() == null ? other.getEmployeeType() == null : this.getEmployeeType().equals(other.getEmployeeType()))
            && (this.getIsPass() == null ? other.getIsPass() == null : this.getIsPass().equals(other.getIsPass()))
            && (this.getResignReason() == null ? other.getResignReason() == null : this.getResignReason().equals(other.getResignReason()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getEmployeeName() == null) ? 0 : getEmployeeName().hashCode());
        result = prime * result + ((getEmployeeUsername() == null) ? 0 : getEmployeeUsername().hashCode());
        result = prime * result + ((getEmployeePassword() == null) ? 0 : getEmployeePassword().hashCode());
        result = prime * result + ((getEmployeeSex() == null) ? 0 : getEmployeeSex().hashCode());
        result = prime * result + ((getEmployeePhone() == null) ? 0 : getEmployeePhone().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getEmployeeType() == null) ? 0 : getEmployeeType().hashCode());
        result = prime * result + ((getIsPass() == null) ? 0 : getIsPass().hashCode());
        result = prime * result + ((getResignReason() == null) ? 0 : getResignReason().hashCode());
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
        sb.append(", employeeUsername=").append(employeeUsername);
        sb.append(", employeePassword=").append(employeePassword);
        sb.append(", employeeSex=").append(employeeSex);
        sb.append(", employeePhone=").append(employeePhone);
        sb.append(", stationId=").append(stationId);
        sb.append(", employeeType=").append(employeeType);
        sb.append(", isPass=").append(isPass);
        sb.append(", resignReason=").append(resignReason);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}