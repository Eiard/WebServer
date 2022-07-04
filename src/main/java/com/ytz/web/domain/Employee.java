package com.ytz.web.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName employee
 */
@TableName(value ="employee")
@Data
public class Employee implements Serializable {
    /**
     * 员工工号
     */
    @TableId(value = "employee_id", type = IdType.AUTO)
    private Integer employee_id;

    /**
     * 员工账号
     */
    @TableField(value = "employee_username")
    private String employee_username;

    /**
     * 员工密码
     */
    @TableField(value = "employee_password")
    private String employee_password;

    /**
     * 员工性别 0 女 1 男
     */
    @TableField(value = "employee_sex")
    private Integer employee_sex;

    /**
     * 员工电话
     */
    @TableField(value = "employee_phone")
    private String employee_phone;

    /**
     * 所属网点ID(自动)
     */
    @TableField(value = "station_id")
    private Integer station_id;

    /**
     * 员工类型ID
     */
    @TableField(value = "employee_type")
    private Integer employee_type;

    /**
     * 审核标志位 [0] 未通过 [1] 
     */
    @TableField(value = "is_pass")
    private Integer is_pass;

    /**
     * 更新日期
     */
    @TableField(value = "create_date")
    private LocalDateTime create_date;

    /**
     *  更新日期
     */
    @TableField(value = "update_date")
    private LocalDateTime update_date;

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
        return (this.getEmployee_id() == null ? other.getEmployee_id() == null : this.getEmployee_id().equals(other.getEmployee_id()))
            && (this.getEmployee_username() == null ? other.getEmployee_username() == null : this.getEmployee_username().equals(other.getEmployee_username()))
            && (this.getEmployee_password() == null ? other.getEmployee_password() == null : this.getEmployee_password().equals(other.getEmployee_password()))
            && (this.getEmployee_sex() == null ? other.getEmployee_sex() == null : this.getEmployee_sex().equals(other.getEmployee_sex()))
            && (this.getEmployee_phone() == null ? other.getEmployee_phone() == null : this.getEmployee_phone().equals(other.getEmployee_phone()))
            && (this.getStation_id() == null ? other.getStation_id() == null : this.getStation_id().equals(other.getStation_id()))
            && (this.getEmployee_type() == null ? other.getEmployee_type() == null : this.getEmployee_type().equals(other.getEmployee_type()))
            && (this.getIs_pass() == null ? other.getIs_pass() == null : this.getIs_pass().equals(other.getIs_pass()))
            && (this.getCreate_date() == null ? other.getCreate_date() == null : this.getCreate_date().equals(other.getCreate_date()))
            && (this.getUpdate_date() == null ? other.getUpdate_date() == null : this.getUpdate_date().equals(other.getUpdate_date()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmployee_id() == null) ? 0 : getEmployee_id().hashCode());
        result = prime * result + ((getEmployee_username() == null) ? 0 : getEmployee_username().hashCode());
        result = prime * result + ((getEmployee_password() == null) ? 0 : getEmployee_password().hashCode());
        result = prime * result + ((getEmployee_sex() == null) ? 0 : getEmployee_sex().hashCode());
        result = prime * result + ((getEmployee_phone() == null) ? 0 : getEmployee_phone().hashCode());
        result = prime * result + ((getStation_id() == null) ? 0 : getStation_id().hashCode());
        result = prime * result + ((getEmployee_type() == null) ? 0 : getEmployee_type().hashCode());
        result = prime * result + ((getIs_pass() == null) ? 0 : getIs_pass().hashCode());
        result = prime * result + ((getCreate_date() == null) ? 0 : getCreate_date().hashCode());
        result = prime * result + ((getUpdate_date() == null) ? 0 : getUpdate_date().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employee_id=").append(employee_id);
        sb.append(", employee_username=").append(employee_username);
        sb.append(", employee_password=").append(employee_password);
        sb.append(", employee_sex=").append(employee_sex);
        sb.append(", employee_phone=").append(employee_phone);
        sb.append(", station_id=").append(station_id);
        sb.append(", employee_type=").append(employee_type);
        sb.append(", is_pass=").append(is_pass);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_date=").append(update_date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}