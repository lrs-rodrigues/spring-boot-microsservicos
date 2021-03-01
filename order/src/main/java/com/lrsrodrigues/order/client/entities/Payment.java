package com.lrsrodrigues.order.client.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrsrodrigues.order.entities.enums.PaymentType;

import java.util.Date;
import java.util.UUID;

public class Payment {

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date moment;

    private Double price;

    private UUID uuid;

    private Integer paymentType;

    public Payment() {};

    public Payment(Integer id, Date moment, Double price, UUID uuid, Integer paymentType) {
        this.id = id;
        this.moment = moment;
        this.price = price;
        this.uuid = uuid;
        this.paymentType = paymentType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
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

    public PaymentType getPaymentType() {
        return PaymentType.valueOf(paymentType);
    }

    public void setPaymentType(PaymentType paymentType) {
        if (paymentType != null) {
            this.paymentType = paymentType.getCode();
        }
    }

}
