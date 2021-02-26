package com.lrsrodrigues.checkout.dto;

import com.lrsrodrigues.checkout.entities.KartItem;

import java.util.List;

public class CheckoutDTO {

    private Integer orderStatus;
    private Integer userId;

    private Integer paymentType;

    private List<KartItem> kartItems;

    public CheckoutDTO(Integer orderStatus, Integer userId, Integer paymentType, List<KartItem> kartItems) {
        this.paymentType = paymentType;
        this.orderStatus = orderStatus;
        this.userId = userId;
        this.kartItems = kartItems;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<KartItem> getKartItems() {
        return kartItems;
    }

    public void setKartItems(List<KartItem> kartItems) {
        this.kartItems = kartItems;
    }
}
