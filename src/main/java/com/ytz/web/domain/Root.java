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
 * @TableName root
 */
@TableName(value ="root")
@Data
public class Root implements Serializable {
    /**
     * 系统管理员ID(自动)
     */
    @TableId(value = "root_id", type = IdType.AUTO)
    private Integer root_id;

    /**
     * 系统管理员姓名
     */
    @TableField(value = "root_name")
    private String root_name;

    /**
     * 系统管理员账号
     */
    @TableField(value = "root_username")
    private String root_username;

    /**
     * 系统管理员密码
     */
    @TableField(value = "root_password")
    private String root_password;

    /**
     * 系统管理员电话
     */
    @TableField(value = "root_phone")
    private String root_phone;

    /**
     * 员工性别 0 女 1 男
     */
    @TableField(value = "root_sex")
    private Integer root_sex;

    /**
     * 默认为0 系统管理员
     */
    @TableField(value = "root_type")
    private Integer root_type;

    /**
     * 创建日期
     */
    @TableField(value = "create_date")
    private LocalDateTime create_date;

    /**
     * 更新日期
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
        Root other = (Root) that;
        return (this.getRoot_id() == null ? other.getRoot_id() == null : this.getRoot_id().equals(other.getRoot_id()))
            && (this.getRoot_name() == null ? other.getRoot_name() == null : this.getRoot_name().equals(other.getRoot_name()))
            && (this.getRoot_username() == null ? other.getRoot_username() == null : this.getRoot_username().equals(other.getRoot_username()))
            && (this.getRoot_password() == null ? other.getRoot_password() == null : this.getRoot_password().equals(other.getRoot_password()))
            && (this.getRoot_phone() == null ? other.getRoot_phone() == null : this.getRoot_phone().equals(other.getRoot_phone()))
            && (this.getRoot_sex() == null ? other.getRoot_sex() == null : this.getRoot_sex().equals(other.getRoot_sex()))
            && (this.getRoot_type() == null ? other.getRoot_type() == null : this.getRoot_type().equals(other.getRoot_type()))
            && (this.getCreate_date() == null ? other.getCreate_date() == null : this.getCreate_date().equals(other.getCreate_date()))
            && (this.getUpdate_date() == null ? other.getUpdate_date() == null : this.getUpdate_date().equals(other.getUpdate_date()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoot_id() == null) ? 0 : getRoot_id().hashCode());
        result = prime * result + ((getRoot_name() == null) ? 0 : getRoot_name().hashCode());
        result = prime * result + ((getRoot_username() == null) ? 0 : getRoot_username().hashCode());
        result = prime * result + ((getRoot_password() == null) ? 0 : getRoot_password().hashCode());
        result = prime * result + ((getRoot_phone() == null) ? 0 : getRoot_phone().hashCode());
        result = prime * result + ((getRoot_sex() == null) ? 0 : getRoot_sex().hashCode());
        result = prime * result + ((getRoot_type() == null) ? 0 : getRoot_type().hashCode());
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
        sb.append(", root_id=").append(root_id);
        sb.append(", root_name=").append(root_name);
        sb.append(", root_username=").append(root_username);
        sb.append(", root_password=").append(root_password);
        sb.append(", root_phone=").append(root_phone);
        sb.append(", root_sex=").append(root_sex);
        sb.append(", root_type=").append(root_type);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_date=").append(update_date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}