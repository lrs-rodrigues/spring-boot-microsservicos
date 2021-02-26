package com.lrsrodrigues.checkout.dto;

import com.lrsrodrigues.checkout.entities.KartItem;

import java.util.List;

public class CheckoutDTO {

    private Integer orderStatus;
    private Integer userId;
    private Integer paymentType;
    private Integer addressId;
    private String deliveryCompany;
    private Double deliveryPrice;

    private List<KartItem> kartItems;

    public CheckoutDTO() {}

    public CheckoutDTO(
            Integer orderStatus,
            Integer userId,
            Integer paymentType,
            Integer addressId,
            String deliveryCompany,
            Double deliveryPrice,
            List<KartItem> kartItems
    ) {
        this.orderStatus = orderStatus;
        this.userId = userId;
        this.paymentType = paymentType;
        this.addressId = addressId;
        this.deliveryCompany = deliveryCompany;
        this.deliveryPrice = deliveryPrice;
        this.kartItems = kartItems;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public List<KartItem> getKartItems() {
        return kartItems;
    }

    public void setKartItems(List<KartItem> kartItems) {
        this.kartItems = kartItems;
    }
}
