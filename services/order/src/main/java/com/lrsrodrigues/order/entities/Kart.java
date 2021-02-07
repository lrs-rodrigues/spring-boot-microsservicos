package com.lrsrodrigues.checkout.entities;

import java.util.List;

public class Kart {

    private Integer orderId;
    private List<KartItem> kartItems;

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
