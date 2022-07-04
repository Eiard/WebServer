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
 * @TableName net_station
 */
@TableName(value ="net_station")
@Data
public class NetStation implements Serializable {
    /**
     * 网点ID 等价于 网点管理员ID
     */
    @TableId(value = "station_id", type = IdType.AUTO)
    private Integer station_id;

    /**
     * 网点名称
     */
    @TableField(value = "station_name")
    private String station_name;

    /**
     * 网点地址
     */
    @TableField(value = "station_address")
    private String station_address;

    /**
     * 网点管理员姓名
     */
    @TableField(value = "admin_name")
    private String admin_name;

    /**
     * 网点管理员账号
     */
    @TableField(value = "admin_username")
    private String admin_username;

    /**
     * 网点管理员密码
     */
    @TableField(value = "admin_password")
    private String admin_password;

    /**
     * 网点管理员电话
     */
    @TableField(value = "admin_phone")
    private String admin_phone;

    /**
     * 员工性别 0 女 1 男
     */
    @TableField(value = "admin_sex")
    private Integer admin_sex;

    /**
     * 默认为1 网点管理员
     */
    @TableField(value = "admin_type")
    private Integer admin_type;

    /**
     * 网点管理员完成的快递单数(月结)
     */
    @TableField(value = "order_amount")
    private Integer order_amount;

    /**
     * 审核标志位 未审核 [0] 审核通过 [1]
     */
    @TableField(value = "is_pass")
    private Integer is_pass;

    /**
     * 网点信息创建日期(创建后不再更改)
     */
    @TableField(value = "create_date")
    private LocalDateTime create_date;

    /**
     * 网点信息更新日期
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
        NetStation other = (NetStation) that;
        return (this.getStation_id() == null ? other.getStation_id() == null : this.getStation_id().equals(other.getStation_id()))
            && (this.getStation_name() == null ? other.getStation_name() == null : this.getStation_name().equals(other.getStation_name()))
            && (this.getStation_address() == null ? other.getStation_address() == null : this.getStation_address().equals(other.getStation_address()))
            && (this.getAdmin_name() == null ? other.getAdmin_name() == null : this.getAdmin_name().equals(other.getAdmin_name()))
            && (this.getAdmin_username() == null ? other.getAdmin_username() == null : this.getAdmin_username().equals(other.getAdmin_username()))
            && (this.getAdmin_password() == null ? other.getAdmin_password() == null : this.getAdmin_password().equals(other.getAdmin_password()))
            && (this.getAdmin_phone() == null ? other.getAdmin_phone() == null : this.getAdmin_phone().equals(other.getAdmin_phone()))
            && (this.getAdmin_sex() == null ? other.getAdmin_sex() == null : this.getAdmin_sex().equals(other.getAdmin_sex()))
            && (this.getAdmin_type() == null ? other.getAdmin_type() == null : this.getAdmin_type().equals(other.getAdmin_type()))
            && (this.getOrder_amount() == null ? other.getOrder_amount() == null : this.getOrder_amount().equals(other.getOrder_amount()))
            && (this.getIs_pass() == null ? other.getIs_pass() == null : this.getIs_pass().equals(other.getIs_pass()))
            && (this.getCreate_date() == null ? other.getCreate_date() == null : this.getCreate_date().equals(other.getCreate_date()))
            && (this.getUpdate_date() == null ? other.getUpdate_date() == null : this.getUpdate_date().equals(other.getUpdate_date()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStation_id() == null) ? 0 : getStation_id().hashCode());
        result = prime * result + ((getStation_name() == null) ? 0 : getStation_name().hashCode());
        result = prime * result + ((getStation_address() == null) ? 0 : getStation_address().hashCode());
        result = prime * result + ((getAdmin_name() == null) ? 0 : getAdmin_name().hashCode());
        result = prime * result + ((getAdmin_username() == null) ? 0 : getAdmin_username().hashCode());
        result = prime * result + ((getAdmin_password() == null) ? 0 : getAdmin_password().hashCode());
        result = prime * result + ((getAdmin_phone() == null) ? 0 : getAdmin_phone().hashCode());
        result = prime * result + ((getAdmin_sex() == null) ? 0 : getAdmin_sex().hashCode());
        result = prime * result + ((getAdmin_type() == null) ? 0 : getAdmin_type().hashCode());
        result = prime * result + ((getOrder_amount() == null) ? 0 : getOrder_amount().hashCode());
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
        sb.append(", station_id=").append(station_id);
        sb.append(", station_name=").append(station_name);
        sb.append(", station_address=").append(station_address);
        sb.append(", admin_name=").append(admin_name);
        sb.append(", admin_username=").append(admin_username);
        sb.append(", admin_password=").append(admin_password);
        sb.append(", admin_phone=").append(admin_phone);
        sb.append(", admin_sex=").append(admin_sex);
        sb.append(", admin_type=").append(admin_type);
        sb.append(", order_amount=").append(order_amount);
        sb.append(", is_pass=").append(is_pass);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_date=").append(update_date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}