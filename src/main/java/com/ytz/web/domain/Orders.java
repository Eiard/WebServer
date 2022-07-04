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
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class Orders implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer order_id;

    /**
     * 订单号(自动)
     */
    @TableField(value = "order_number")
    private String order_number;

    /**
     * 发货网点(自动)
     */
    @TableField(value = "start_point")
    private Integer start_point;

    /**
     * 发货网点地址(自动)
     */
    @TableField(value = "start_address")
    private String start_address;

    /**
     * 收货网点
     */
    @TableField(value = "end_point")
    private Integer end_point;

    /**
     * 收发货网点地址(自动)
     */
    @TableField(value = "end_address")
    private String end_address;

    /**
     * 货物重量
     */
    @TableField(value = "good_weight")
    private Double good_weight;

    /**
     * 货物类型
     */
    @TableField(value = "good_type")
    private Integer good_type;

    /**
     * 订单价格
     */
    @TableField(value = "order_price")
    private Double order_price;

    /**
     * 发货人姓名
     */
    @TableField(value = "consignor")
    private String consignor;

    /**
     * 发货人电话
     */
    @TableField(value = "consignor_phone")
    private String consignor_phone;

    /**
     * 收件人姓名
     */
    @TableField(value = "recipient")
    private String recipient;

    /**
     * 收件人电话
     */
    @TableField(value = "recipient_phone")
    private String recipient_phone;

    /**
     * 收件人地址
     */
    @TableField(value = "recipient_address")
    private String recipient_address;

    /**
     * 备注信息
     */
    @TableField(value = "notes")
    private String notes;

    /**
     * 订单状态：[0]未收件 [1]已收件 [2]配送中 [3]已收货
     */
    @TableField(value = "order_status")
    private Integer order_status;

    /**
     * 派送员工号
     */
    @TableField(value = "sender_id")
    private Integer sender_id;

    /**
     * 派送员姓名
     */
    @TableField(value = "sender_name")
    private String sender_name;

    /**
     * 派送员电话
     */
    @TableField(value = "sender_phone")
    private String sender_phone;

    /**
     * 订单结束标志位:[0]未完成 [1]已完成
     */
    @TableField(value = "is_deleted")
    private Integer is_deleted;

    /**
     * 订单创建日期(创建后不再更改)
     */
    @TableField(value = "create_date")
    private LocalDateTime create_date;

    /**
     * 订单更新日期
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
        Orders other = (Orders) that;
        return (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()))
            && (this.getOrder_number() == null ? other.getOrder_number() == null : this.getOrder_number().equals(other.getOrder_number()))
            && (this.getStart_point() == null ? other.getStart_point() == null : this.getStart_point().equals(other.getStart_point()))
            && (this.getStart_address() == null ? other.getStart_address() == null : this.getStart_address().equals(other.getStart_address()))
            && (this.getEnd_point() == null ? other.getEnd_point() == null : this.getEnd_point().equals(other.getEnd_point()))
            && (this.getEnd_address() == null ? other.getEnd_address() == null : this.getEnd_address().equals(other.getEnd_address()))
            && (this.getGood_weight() == null ? other.getGood_weight() == null : this.getGood_weight().equals(other.getGood_weight()))
            && (this.getGood_type() == null ? other.getGood_type() == null : this.getGood_type().equals(other.getGood_type()))
            && (this.getOrder_price() == null ? other.getOrder_price() == null : this.getOrder_price().equals(other.getOrder_price()))
            && (this.getConsignor() == null ? other.getConsignor() == null : this.getConsignor().equals(other.getConsignor()))
            && (this.getConsignor_phone() == null ? other.getConsignor_phone() == null : this.getConsignor_phone().equals(other.getConsignor_phone()))
            && (this.getRecipient() == null ? other.getRecipient() == null : this.getRecipient().equals(other.getRecipient()))
            && (this.getRecipient_phone() == null ? other.getRecipient_phone() == null : this.getRecipient_phone().equals(other.getRecipient_phone()))
            && (this.getRecipient_address() == null ? other.getRecipient_address() == null : this.getRecipient_address().equals(other.getRecipient_address()))
            && (this.getNotes() == null ? other.getNotes() == null : this.getNotes().equals(other.getNotes()))
            && (this.getOrder_status() == null ? other.getOrder_status() == null : this.getOrder_status().equals(other.getOrder_status()))
            && (this.getSender_id() == null ? other.getSender_id() == null : this.getSender_id().equals(other.getSender_id()))
            && (this.getSender_name() == null ? other.getSender_name() == null : this.getSender_name().equals(other.getSender_name()))
            && (this.getSender_phone() == null ? other.getSender_phone() == null : this.getSender_phone().equals(other.getSender_phone()))
            && (this.getIs_deleted() == null ? other.getIs_deleted() == null : this.getIs_deleted().equals(other.getIs_deleted()))
            && (this.getCreate_date() == null ? other.getCreate_date() == null : this.getCreate_date().equals(other.getCreate_date()))
            && (this.getUpdate_date() == null ? other.getUpdate_date() == null : this.getUpdate_date().equals(other.getUpdate_date()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        result = prime * result + ((getOrder_number() == null) ? 0 : getOrder_number().hashCode());
        result = prime * result + ((getStart_point() == null) ? 0 : getStart_point().hashCode());
        result = prime * result + ((getStart_address() == null) ? 0 : getStart_address().hashCode());
        result = prime * result + ((getEnd_point() == null) ? 0 : getEnd_point().hashCode());
        result = prime * result + ((getEnd_address() == null) ? 0 : getEnd_address().hashCode());
        result = prime * result + ((getGood_weight() == null) ? 0 : getGood_weight().hashCode());
        result = prime * result + ((getGood_type() == null) ? 0 : getGood_type().hashCode());
        result = prime * result + ((getOrder_price() == null) ? 0 : getOrder_price().hashCode());
        result = prime * result + ((getConsignor() == null) ? 0 : getConsignor().hashCode());
        result = prime * result + ((getConsignor_phone() == null) ? 0 : getConsignor_phone().hashCode());
        result = prime * result + ((getRecipient() == null) ? 0 : getRecipient().hashCode());
        result = prime * result + ((getRecipient_phone() == null) ? 0 : getRecipient_phone().hashCode());
        result = prime * result + ((getRecipient_address() == null) ? 0 : getRecipient_address().hashCode());
        result = prime * result + ((getNotes() == null) ? 0 : getNotes().hashCode());
        result = prime * result + ((getOrder_status() == null) ? 0 : getOrder_status().hashCode());
        result = prime * result + ((getSender_id() == null) ? 0 : getSender_id().hashCode());
        result = prime * result + ((getSender_name() == null) ? 0 : getSender_name().hashCode());
        result = prime * result + ((getSender_phone() == null) ? 0 : getSender_phone().hashCode());
        result = prime * result + ((getIs_deleted() == null) ? 0 : getIs_deleted().hashCode());
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
        sb.append(", order_id=").append(order_id);
        sb.append(", order_number=").append(order_number);
        sb.append(", start_point=").append(start_point);
        sb.append(", start_address=").append(start_address);
        sb.append(", end_point=").append(end_point);
        sb.append(", end_address=").append(end_address);
        sb.append(", good_weight=").append(good_weight);
        sb.append(", good_type=").append(good_type);
        sb.append(", order_price=").append(order_price);
        sb.append(", consignor=").append(consignor);
        sb.append(", consignor_phone=").append(consignor_phone);
        sb.append(", recipient=").append(recipient);
        sb.append(", recipient_phone=").append(recipient_phone);
        sb.append(", recipient_address=").append(recipient_address);
        sb.append(", notes=").append(notes);
        sb.append(", order_status=").append(order_status);
        sb.append(", sender_id=").append(sender_id);
        sb.append(", sender_name=").append(sender_name);
        sb.append(", sender_phone=").append(sender_phone);
        sb.append(", is_deleted=").append(is_deleted);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_date=").append(update_date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}