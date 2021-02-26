package com.lrsrodrigues.checkout.entities;

import java.util.UUID;

public class Payment {

    private Double price;

    private UUID uuid;

    private Integer paymentType;

    public Payment() {}

    public Payment(Double price, UUID uuid, Integer paymentType) {
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
        return "Payment [uuid=" + uuid + ", price=" + price + ", paymentType=" +  paymentType + "]";
    }
}
