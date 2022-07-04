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
    private Integer rootId;

    /**
     * 系统管理员姓名
     */
    @TableField(value = "root_name")
    private String rootName;

    /**
     * 系统管理员账号
     */
    @TableField(value = "root_username")
    private String rootUsername;

    /**
     * 系统管理员密码
     */
    @TableField(value = "root_password")
    private String rootPassword;

    /**
     * 系统管理员电话
     */
    @TableField(value = "root_phone")
    private String rootPhone;

    /**
     * 员工性别 0 女 1 男
     */
    @TableField(value = "root_sex")
    private Integer rootSex;

    /**
     * 默认为0 系统管理员
     */
    @TableField(value = "root_type")
    private Integer rootType;

    /**
     * 创建日期
     */
    @TableField(value = "create_date")
    private LocalDateTime createDate;

    /**
     * 更新日期
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
        Root other = (Root) that;
        return (this.getRootId() == null ? other.getRootId() == null : this.getRootId().equals(other.getRootId()))
            && (this.getRootName() == null ? other.getRootName() == null : this.getRootName().equals(other.getRootName()))
            && (this.getRootUsername() == null ? other.getRootUsername() == null : this.getRootUsername().equals(other.getRootUsername()))
            && (this.getRootPassword() == null ? other.getRootPassword() == null : this.getRootPassword().equals(other.getRootPassword()))
            && (this.getRootPhone() == null ? other.getRootPhone() == null : this.getRootPhone().equals(other.getRootPhone()))
            && (this.getRootSex() == null ? other.getRootSex() == null : this.getRootSex().equals(other.getRootSex()))
            && (this.getRootType() == null ? other.getRootType() == null : this.getRootType().equals(other.getRootType()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRootId() == null) ? 0 : getRootId().hashCode());
        result = prime * result + ((getRootName() == null) ? 0 : getRootName().hashCode());
        result = prime * result + ((getRootUsername() == null) ? 0 : getRootUsername().hashCode());
        result = prime * result + ((getRootPassword() == null) ? 0 : getRootPassword().hashCode());
        result = prime * result + ((getRootPhone() == null) ? 0 : getRootPhone().hashCode());
        result = prime * result + ((getRootSex() == null) ? 0 : getRootSex().hashCode());
        result = prime * result + ((getRootType() == null) ? 0 : getRootType().hashCode());
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
        sb.append(", rootId=").append(rootId);
        sb.append(", rootName=").append(rootName);
        sb.append(", rootUsername=").append(rootUsername);
        sb.append(", rootPassword=").append(rootPassword);
        sb.append(", rootPhone=").append(rootPhone);
        sb.append(", rootSex=").append(rootSex);
        sb.append(", rootType=").append(rootType);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}