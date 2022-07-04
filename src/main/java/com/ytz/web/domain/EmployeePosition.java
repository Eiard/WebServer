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
 * @TableName employee_position
 */
@TableName(value ="employee_position")
@Data
public class EmployeePosition implements Serializable {
    /**
     *  员工职位ID
     */
    @TableId(value = "position_id", type = IdType.AUTO)
    private Integer position_id;

    /**
     *  职位名称
     */
    @TableField(value = "position_name")
    private String position_name;

    /**
     * 基本工资
     */
    @TableField(value = "basic_salary")
    private Double basic_salary;

    /**
     * 员工类型创建日期
     */
    @TableField(value = "create_date")
    private LocalDateTime create_date;

    /**
     * 员工类型更新日期
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
        EmployeePosition other = (EmployeePosition) that;
        return (this.getPosition_id() == null ? other.getPosition_id() == null : this.getPosition_id().equals(other.getPosition_id()))
            && (this.getPosition_name() == null ? other.getPosition_name() == null : this.getPosition_name().equals(other.getPosition_name()))
            && (this.getBasic_salary() == null ? other.getBasic_salary() == null : this.getBasic_salary().equals(other.getBasic_salary()))
            && (this.getCreate_date() == null ? other.getCreate_date() == null : this.getCreate_date().equals(other.getCreate_date()))
            && (this.getUpdate_date() == null ? other.getUpdate_date() == null : this.getUpdate_date().equals(other.getUpdate_date()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPosition_id() == null) ? 0 : getPosition_id().hashCode());
        result = prime * result + ((getPosition_name() == null) ? 0 : getPosition_name().hashCode());
        result = prime * result + ((getBasic_salary() == null) ? 0 : getBasic_salary().hashCode());
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
        sb.append(", position_id=").append(position_id);
        sb.append(", position_name=").append(position_name);
        sb.append(", basic_salary=").append(basic_salary);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_date=").append(update_date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}