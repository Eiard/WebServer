package com.ytz.web.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * -*- coding:utf-8 -*-
 *
 * @projectName: web
 * @package: com.ytz.web.domain
 * @className: NetStation
 * @author: 30671
 * @description: DONE : 网点
 * @date: 2022/7/15
 * @TableName net_station
 * @version: 1.0
 */
@TableName(value ="net_station")
@Data
public class NetStation implements Serializable {
    /**
     * 网点ID 等价于 网点管理员ID
     */
    @TableId(value = "station_id", type = IdType.AUTO)
    private Integer stationId;

    /**
     * 网点名称
     */
    @TableField(value = "station_name")
    private String stationName;

    /**
     * 网点地址
     */
    @TableField(value = "station_address")
    private String stationAddress;

    /**
     * 网点管理员姓名
     */
    @TableField(value = "admin_name")
    private String adminName;

    /**
     * 网点管理员账号
     */
    @TableField(value = "admin_username")
    private String adminUsername;

    /**
     * 网点管理员密码
     */
    @TableField(value = "admin_password")
    private String adminPassword;

    /**
     * 网点管理员电话
     */
    @TableField(value = "admin_phone")
    private String adminPhone;

    /**
     * 员工性别 0 女 1 男
     */
    @TableField(value = "admin_sex")
    private Boolean adminSex;

    /**
     * 默认为2 网点管理员
     */
    @TableField(value = "admin_type")
    private Integer adminType;

    /**
     * 网点管理员完成的快递单数(月结)
     */
    @TableField(value = "order_amount")
    private Integer orderAmount;

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
        NetStation other = (NetStation) that;
        return (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getStationName() == null ? other.getStationName() == null : this.getStationName().equals(other.getStationName()))
            && (this.getStationAddress() == null ? other.getStationAddress() == null : this.getStationAddress().equals(other.getStationAddress()))
            && (this.getAdminName() == null ? other.getAdminName() == null : this.getAdminName().equals(other.getAdminName()))
            && (this.getAdminUsername() == null ? other.getAdminUsername() == null : this.getAdminUsername().equals(other.getAdminUsername()))
            && (this.getAdminPassword() == null ? other.getAdminPassword() == null : this.getAdminPassword().equals(other.getAdminPassword()))
            && (this.getAdminPhone() == null ? other.getAdminPhone() == null : this.getAdminPhone().equals(other.getAdminPhone()))
            && (this.getAdminSex() == null ? other.getAdminSex() == null : this.getAdminSex().equals(other.getAdminSex()))
            && (this.getAdminType() == null ? other.getAdminType() == null : this.getAdminType().equals(other.getAdminType()))
            && (this.getOrderAmount() == null ? other.getOrderAmount() == null : this.getOrderAmount().equals(other.getOrderAmount()))
            && (this.getIsPass() == null ? other.getIsPass() == null : this.getIsPass().equals(other.getIsPass()))
            && (this.getResignReason() == null ? other.getResignReason() == null : this.getResignReason().equals(other.getResignReason()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getStationName() == null) ? 0 : getStationName().hashCode());
        result = prime * result + ((getStationAddress() == null) ? 0 : getStationAddress().hashCode());
        result = prime * result + ((getAdminName() == null) ? 0 : getAdminName().hashCode());
        result = prime * result + ((getAdminUsername() == null) ? 0 : getAdminUsername().hashCode());
        result = prime * result + ((getAdminPassword() == null) ? 0 : getAdminPassword().hashCode());
        result = prime * result + ((getAdminPhone() == null) ? 0 : getAdminPhone().hashCode());
        result = prime * result + ((getAdminSex() == null) ? 0 : getAdminSex().hashCode());
        result = prime * result + ((getAdminType() == null) ? 0 : getAdminType().hashCode());
        result = prime * result + ((getOrderAmount() == null) ? 0 : getOrderAmount().hashCode());
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
        sb.append(", stationId=").append(stationId);
        sb.append(", stationName=").append(stationName);
        sb.append(", stationAddress=").append(stationAddress);
        sb.append(", adminName=").append(adminName);
        sb.append(", adminUsername=").append(adminUsername);
        sb.append(", adminPassword=").append(adminPassword);
        sb.append(", adminPhone=").append(adminPhone);
        sb.append(", adminSex=").append(adminSex);
        sb.append(", adminType=").append(adminType);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", isPass=").append(isPass);
        sb.append(", resignReason=").append(resignReason);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}