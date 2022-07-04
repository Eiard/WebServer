package com.ytz.web.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.domain
 * @className: EmployeePosition
 * @author: 30671
 * @description: DONE : 员工实例化对象
 * @date: 2022/7/4
 * @TableName employee_position
 * @version: 1.0
 */
@TableName(value ="employee_position")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePosition implements Serializable {
    /**
     *  员工职位ID
     */
    @TableId(value = "position_id", type = IdType.AUTO)
    private Integer positionId;

    /**
     *  职位名称
     */
    @TableField(value = "position_name")
    private String positionName;

    /**
     * 基本工资
     */
    @TableField(value = "basic_salary")
    private Double basicSalary;

    /**
     * 员工类型创建日期
     */
    @TableField(value = "create_date")
    private LocalDateTime createDate;

    /**
     * 员工类型更新日期
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
        EmployeePosition other = (EmployeePosition) that;
        return (this.getPositionId() == null ? other.getPositionId() == null : this.getPositionId().equals(other.getPositionId()))
            && (this.getPositionName() == null ? other.getPositionName() == null : this.getPositionName().equals(other.getPositionName()))
            && (this.getBasicSalary() == null ? other.getBasicSalary() == null : this.getBasicSalary().equals(other.getBasicSalary()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPositionId() == null) ? 0 : getPositionId().hashCode());
        result = prime * result + ((getPositionName() == null) ? 0 : getPositionName().hashCode());
        result = prime * result + ((getBasicSalary() == null) ? 0 : getBasicSalary().hashCode());
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
        sb.append(", positionId=").append(positionId);
        sb.append(", positionName=").append(positionName);
        sb.append(", basicSalary=").append(basicSalary);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}