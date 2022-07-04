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
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer user_id;

    /**
     * 用户账号
     */
    @TableField(value = "user_username")
    private String user_username;

    /**
     * 用户密码
     */
    @TableField(value = "user_password")
    private String user_password;

    /**
     * 用户性别 0 女 1 男
     */
    @TableField(value = "user_sex")
    private Integer user_sex;

    /**
     * 用户电话(通过手机号来查询自己的订单表)
     */
    @TableField(value = "user_phone")
    private String user_phone;

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
        User other = (User) that;
        return (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getUser_username() == null ? other.getUser_username() == null : this.getUser_username().equals(other.getUser_username()))
            && (this.getUser_password() == null ? other.getUser_password() == null : this.getUser_password().equals(other.getUser_password()))
            && (this.getUser_sex() == null ? other.getUser_sex() == null : this.getUser_sex().equals(other.getUser_sex()))
            && (this.getUser_phone() == null ? other.getUser_phone() == null : this.getUser_phone().equals(other.getUser_phone()))
            && (this.getCreate_date() == null ? other.getCreate_date() == null : this.getCreate_date().equals(other.getCreate_date()))
            && (this.getUpdate_date() == null ? other.getUpdate_date() == null : this.getUpdate_date().equals(other.getUpdate_date()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getUser_username() == null) ? 0 : getUser_username().hashCode());
        result = prime * result + ((getUser_password() == null) ? 0 : getUser_password().hashCode());
        result = prime * result + ((getUser_sex() == null) ? 0 : getUser_sex().hashCode());
        result = prime * result + ((getUser_phone() == null) ? 0 : getUser_phone().hashCode());
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
        sb.append(", user_id=").append(user_id);
        sb.append(", user_username=").append(user_username);
        sb.append(", user_password=").append(user_password);
        sb.append(", user_sex=").append(user_sex);
        sb.append(", user_phone=").append(user_phone);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_date=").append(update_date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}