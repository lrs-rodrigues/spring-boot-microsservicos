package com.lrsrodrigues.order.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Kart {

    @JsonProperty("orderId")
    private Integer orderId;

    @JsonProperty("kartItems")
    private List<KartItem> kartItems;

    public Kart() {}

    public Kart(Integer orderId, List<KartItem> kartItems) {
        this.orderId = orderId;
        this.kartItems = kartItems;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<KartItem> getKartItems() {
        return kartItems;
    }

    public void setKartItems(List<KartItem> kartItems) {
        this.kartItems = kartItems;
    }

    public String toString() {
        return "Kart [orderId=" + orderId + ", kartItems=" +  kartItems + "]";
    }
}
