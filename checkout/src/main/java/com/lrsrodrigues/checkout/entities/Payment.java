package com.lrsrodrigues.checkout.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PaymentPayload {

    @JsonProperty("price")
    private Double price;

    @JsonProperty("uuid")
    private UUID uuid;

    @JsonProperty("paymentType")
    private Integer paymentType;

    public PaymentPayload() {}

    public PaymentPayload(Double price, UUID uuid, Integer paymentType) {
        this.price = price;
        this.uuid = uuid;
        this.paymentType = paymentType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String toString() {
        return "PaymentPayload [uuid=" + uuid + ", price=" + price + ", paymentType=" +  paymentType + "]";
    }
}
