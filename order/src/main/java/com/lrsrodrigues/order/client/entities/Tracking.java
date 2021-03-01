package com.lrsrodrigues.order.client.entities;

import java.util.UUID;

public class Tracking {

    private Integer id;

    private Integer addressId;

    private UUID uuid;

    private String deliveryCompany;

    private Double deliveryPrice;

    public Tracking() {}

    public Tracking(Integer id, Integer addressId, UUID uuid, String deliveryCompany, Double deliveryPrice) {
        this.id = id;
        this.addressId = addressId;
        this.uuid = uuid;
        this.deliveryCompany = deliveryCompany;
        this.deliveryPrice = deliveryPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
