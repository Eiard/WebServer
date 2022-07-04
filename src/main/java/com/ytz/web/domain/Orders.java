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
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单号(自动)
     */
    @TableField(value = "order_number")
    private String orderNumber;

    /**
     * 发货网点(自动)
     */
    @TableField(value = "start_point")
    private Integer startPoint;

    /**
     * 发货网点地址(自动)
     */
    @TableField(value = "start_address")
    private String startAddress;

    /**
     * 收货网点
     */
    @TableField(value = "end_point")
    private Integer endPoint;

    /**
     * 收发货网点地址(自动)
     */
    @TableField(value = "end_address")
    private String endAddress;

    /**
     * 货物重量
     */
    @TableField(value = "good_weight")
    private Double goodWeight;

    /**
     * 货物类型
     */
    @TableField(value = "good_type")
    private Integer goodType;

    /**
     * 订单价格
     */
    @TableField(value = "order_price")
    private Double orderPrice;

    /**
     * 发货人姓名
     */
    @TableField(value = "consignor")
    private String consignor;

    /**
     * 发货人电话
     */
    @TableField(value = "consignor_phone")
    private String consignorPhone;

    /**
     * 收件人姓名
     */
    @TableField(value = "recipient")
    private String recipient;

    /**
     * 收件人电话
     */
    @TableField(value = "recipient_phone")
    private String recipientPhone;

    /**
     * 收件人地址
     */
    @TableField(value = "recipient_address")
    private String recipientAddress;

    /**
     * 备注信息
     */
    @TableField(value = "notes")
    private String notes;

    /**
     * 订单状态：[0]未收件 [1]已收件 [2]配送中 [3]已收货
     */
    @TableField(value = "order_status")
    private Integer orderStatus;

    /**
     * 派送员工号
     */
    @TableField(value = "sender_id")
    private Integer senderId;

    /**
     * 派送员姓名
     */
    @TableField(value = "sender_name")
    private String senderName;

    /**
     * 派送员电话
     */
    @TableField(value = "sender_phone")
    private String senderPhone;

    /**
     * 订单结束标志位:[0]未完成 [1]已完成
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    /**
     * 订单创建日期(创建后不再更改)
     */
    @TableField(value = "create_date")
    private LocalDateTime createDate;

    /**
     * 订单更新日期
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
        Orders other = (Orders) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getStartPoint() == null ? other.getStartPoint() == null : this.getStartPoint().equals(other.getStartPoint()))
            && (this.getStartAddress() == null ? other.getStartAddress() == null : this.getStartAddress().equals(other.getStartAddress()))
            && (this.getEndPoint() == null ? other.getEndPoint() == null : this.getEndPoint().equals(other.getEndPoint()))
            && (this.getEndAddress() == null ? other.getEndAddress() == null : this.getEndAddress().equals(other.getEndAddress()))
            && (this.getGoodWeight() == null ? other.getGoodWeight() == null : this.getGoodWeight().equals(other.getGoodWeight()))
            && (this.getGoodType() == null ? other.getGoodType() == null : this.getGoodType().equals(other.getGoodType()))
            && (this.getOrderPrice() == null ? other.getOrderPrice() == null : this.getOrderPrice().equals(other.getOrderPrice()))
            && (this.getConsignor() == null ? other.getConsignor() == null : this.getConsignor().equals(other.getConsignor()))
            && (this.getConsignorPhone() == null ? other.getConsignorPhone() == null : this.getConsignorPhone().equals(other.getConsignorPhone()))
            && (this.getRecipient() == null ? other.getRecipient() == null : this.getRecipient().equals(other.getRecipient()))
            && (this.getRecipientPhone() == null ? other.getRecipientPhone() == null : this.getRecipientPhone().equals(other.getRecipientPhone()))
            && (this.getRecipientAddress() == null ? other.getRecipientAddress() == null : this.getRecipientAddress().equals(other.getRecipientAddress()))
            && (this.getNotes() == null ? other.getNotes() == null : this.getNotes().equals(other.getNotes()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getSenderId() == null ? other.getSenderId() == null : this.getSenderId().equals(other.getSenderId()))
            && (this.getSenderName() == null ? other.getSenderName() == null : this.getSenderName().equals(other.getSenderName()))
            && (this.getSenderPhone() == null ? other.getSenderPhone() == null : this.getSenderPhone().equals(other.getSenderPhone()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getStartPoint() == null) ? 0 : getStartPoint().hashCode());
        result = prime * result + ((getStartAddress() == null) ? 0 : getStartAddress().hashCode());
        result = prime * result + ((getEndPoint() == null) ? 0 : getEndPoint().hashCode());
        result = prime * result + ((getEndAddress() == null) ? 0 : getEndAddress().hashCode());
        result = prime * result + ((getGoodWeight() == null) ? 0 : getGoodWeight().hashCode());
        result = prime * result + ((getGoodType() == null) ? 0 : getGoodType().hashCode());
        result = prime * result + ((getOrderPrice() == null) ? 0 : getOrderPrice().hashCode());
        result = prime * result + ((getConsignor() == null) ? 0 : getConsignor().hashCode());
        result = prime * result + ((getConsignorPhone() == null) ? 0 : getConsignorPhone().hashCode());
        result = prime * result + ((getRecipient() == null) ? 0 : getRecipient().hashCode());
        result = prime * result + ((getRecipientPhone() == null) ? 0 : getRecipientPhone().hashCode());
        result = prime * result + ((getRecipientAddress() == null) ? 0 : getRecipientAddress().hashCode());
        result = prime * result + ((getNotes() == null) ? 0 : getNotes().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getSenderId() == null) ? 0 : getSenderId().hashCode());
        result = prime * result + ((getSenderName() == null) ? 0 : getSenderName().hashCode());
        result = prime * result + ((getSenderPhone() == null) ? 0 : getSenderPhone().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
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
        sb.append(", orderId=").append(orderId);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", startPoint=").append(startPoint);
        sb.append(", startAddress=").append(startAddress);
        sb.append(", endPoint=").append(endPoint);
        sb.append(", endAddress=").append(endAddress);
        sb.append(", goodWeight=").append(goodWeight);
        sb.append(", goodType=").append(goodType);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", consignor=").append(consignor);
        sb.append(", consignorPhone=").append(consignorPhone);
        sb.append(", recipient=").append(recipient);
        sb.append(", recipientPhone=").append(recipientPhone);
        sb.append(", recipientAddress=").append(recipientAddress);
        sb.append(", notes=").append(notes);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", senderId=").append(senderId);
        sb.append(", senderName=").append(senderName);
        sb.append(", senderPhone=").append(senderPhone);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}