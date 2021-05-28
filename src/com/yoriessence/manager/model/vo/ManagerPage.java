package com.yoriessence.manager.model.vo;

import java.util.Date;
import java.util.Objects;

public class ManagerPage {
    private int rowNum;
    private int OrderNumber;
    private String MemberId;
    private String memberName;
    private int OrderAmount;
    private String Payment;
    private String PaymentStatus;
    private String ShippingStatus;
    private String Waybill;
    private int AmountPrice;
    private Date OrderDate;
    private Date PaymentDate;

    public ManagerPage() {
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String memberId) {
        MemberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getOrderAmount() {
        return OrderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        OrderAmount = orderAmount;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String payment) {
        Payment = payment;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        PaymentStatus = paymentStatus;
    }

    public String getShippingStatus() {
        return ShippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        ShippingStatus = shippingStatus;
    }

    public String getWaybill() {
        return Waybill;
    }

    public void setWaybill(String waybill) {
        Waybill = waybill;
    }

    public int getAmountPrice() {
        return AmountPrice;
    }

    public void setAmountPrice(int amountPrice) {
        AmountPrice = amountPrice;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public Date getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        PaymentDate = paymentDate;
    }
}
