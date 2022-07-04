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
 * @TableName finance
 */
@TableName(value ="finance")
@Data
public class Finance implements Serializable {
    /**
     * 员工ID
     */
    @TableField(value = "employee_id")
    private Integer employee_id;

    /**
     * 员工姓名
     */
    @TableField(value = "employee_name")
    private String employee_name;

    /**
     * 员工薪水(税前)
     */
    @TableField(value = "salary")
    private Double salary;

    /**
     * 快递单数
     */
    @TableField(value = "order_amount")
    private Integer order_amount;

    /**
     * 员工总工资(税后)
     */
    @TableField(value = "total_salary")
    private Double total_salary;

    /**
     * 薪水创建日期(创建后不再更改)
     */
    @TableField(value = "create_date")
    private LocalDateTime create_date;

    /**
     * 薪水更新日期
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
        Finance other = (Finance) that;
        return (this.getEmployee_id() == null ? other.getEmployee_id() == null : this.getEmployee_id().equals(other.getEmployee_id()))
            && (this.getEmployee_name() == null ? other.getEmployee_name() == null : this.getEmployee_name().equals(other.getEmployee_name()))
            && (this.getSalary() == null ? other.getSalary() == null : this.getSalary().equals(other.getSalary()))
            && (this.getOrder_amount() == null ? other.getOrder_amount() == null : this.getOrder_amount().equals(other.getOrder_amount()))
            && (this.getTotal_salary() == null ? other.getTotal_salary() == null : this.getTotal_salary().equals(other.getTotal_salary()))
            && (this.getCreate_date() == null ? other.getCreate_date() == null : this.getCreate_date().equals(other.getCreate_date()))
            && (this.getUpdate_date() == null ? other.getUpdate_date() == null : this.getUpdate_date().equals(other.getUpdate_date()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmployee_id() == null) ? 0 : getEmployee_id().hashCode());
        result = prime * result + ((getEmployee_name() == null) ? 0 : getEmployee_name().hashCode());
        result = prime * result + ((getSalary() == null) ? 0 : getSalary().hashCode());
        result = prime * result + ((getOrder_amount() == null) ? 0 : getOrder_amount().hashCode());
        result = prime * result + ((getTotal_salary() == null) ? 0 : getTotal_salary().hashCode());
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
        sb.append(", employee_name=").append(employee_name);
        sb.append(", salary=").append(salary);
        sb.append(", order_amount=").append(order_amount);
        sb.append(", total_salary=").append(total_salary);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_date=").append(update_date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}