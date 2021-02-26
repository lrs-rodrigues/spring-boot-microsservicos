package com.lrsrodrigues.checkout.entities;

import java.util.UUID;

public class Tracking {

    private Integer addressId;
    private UUID uuid;
    private String deliveryCompany;
    private Double deliveryPrice;

    public Tracking() {}

    public Tracking(Integer addressId, UUID uuid, String deliveryCompany, Double deliveryPrice) {
        this.addressId = addressId;
        this.uuid = uuid;
        this.deliveryCompany = deliveryCompany;
        this.deliveryPrice = deliveryPrice;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public String toString() {
        return "Tracking [addressId=" + addressId +
                ", uuid=" + uuid +
                ", deliveryCompany=" + deliveryCompany +
                ", deliveryPrice = " + deliveryPrice +
                "]";
    }
}
