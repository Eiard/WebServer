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
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "order_id")
    private String order_id;

    /**
     * 货物类型
     */
    @TableField(value = "order_type")
    private Integer order_type;

    /**
     * 
     */
    @TableField(value = "start_point")
    private Integer start_point;

    /**
     * 
     */
    @TableField(value = "start_address")
    private String start_address;

    /**
     * 
     */
    @TableField(value = "end_point")
    private Integer end_point;

    /**
     * 
     */
    @TableField(value = "end_address")
    private String end_address;

    /**
     * 
     */
    @TableField(value = "consignor")
    private String consignor;

    /**
     * 
     */
    @TableField(value = "consignor_phone")
    private String consignor_phone;

    /**
     * 
     */
    @TableField(value = "recipient")
    private String recipient;

    /**
     * 
     */
    @TableField(value = "recipient_phone")
    private String recipient_phone;

    /**
     * 
     */
    @TableField(value = "recipient_address")
    private String recipient_address;

    /**
     * 
     */
    @TableField(value = "notes")
    private String notes;

    /**
     * 
     */
    @TableField(value = "order_status")
    private Integer order_status;

    /**
     * 
     */
    @TableField(value = "sender_id")
    private Integer sender_id;

    /**
     * 
     */
    @TableField(value = "sender_name")
    private String sender_name;

    /**
     * 
     */
    @TableField(value = "sender_phone")
    private String sender_phone;

    /**
     * 
     */
    @TableField(value = "is_delete")
    private Integer is_delete;

    /**
     * 
     */
    @TableField(value = "create_date")
    private LocalDateTime create_date;

    /**
     * 
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
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()))
            && (this.getOrder_type() == null ? other.getOrder_type() == null : this.getOrder_type().equals(other.getOrder_type()))
            && (this.getStart_point() == null ? other.getStart_point() == null : this.getStart_point().equals(other.getStart_point()))
            && (this.getStart_address() == null ? other.getStart_address() == null : this.getStart_address().equals(other.getStart_address()))
            && (this.getEnd_point() == null ? other.getEnd_point() == null : this.getEnd_point().equals(other.getEnd_point()))
            && (this.getEnd_address() == null ? other.getEnd_address() == null : this.getEnd_address().equals(other.getEnd_address()))
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
            && (this.getIs_delete() == null ? other.getIs_delete() == null : this.getIs_delete().equals(other.getIs_delete()))
            && (this.getCreate_date() == null ? other.getCreate_date() == null : this.getCreate_date().equals(other.getCreate_date()))
            && (this.getUpdate_date() == null ? other.getUpdate_date() == null : this.getUpdate_date().equals(other.getUpdate_date()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        result = prime * result + ((getOrder_type() == null) ? 0 : getOrder_type().hashCode());
        result = prime * result + ((getStart_point() == null) ? 0 : getStart_point().hashCode());
        result = prime * result + ((getStart_address() == null) ? 0 : getStart_address().hashCode());
        result = prime * result + ((getEnd_point() == null) ? 0 : getEnd_point().hashCode());
        result = prime * result + ((getEnd_address() == null) ? 0 : getEnd_address().hashCode());
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
        result = prime * result + ((getIs_delete() == null) ? 0 : getIs_delete().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", order_id=").append(order_id);
        sb.append(", order_type=").append(order_type);
        sb.append(", start_point=").append(start_point);
        sb.append(", start_address=").append(start_address);
        sb.append(", end_point=").append(end_point);
        sb.append(", end_address=").append(end_address);
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
        sb.append(", is_delete=").append(is_delete);
        sb.append(", create_date=").append(create_date);
        sb.append(", update_date=").append(update_date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}