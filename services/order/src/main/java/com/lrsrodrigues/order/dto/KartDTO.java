package com.lrsrodrigues.order.dto;

import java.util.List;

public class KartDTO {

    private Integer orderId;
    private List<KartItemDTO> kartItems;

    public KartDTO(Integer orderId, List<KartItemDTO> kartItems) {
        this.orderId = orderId;
        this.kartItems = kartItems;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<KartItemDTO> getKartItems() {
        return kartItems;
    }

    public void setKartItems(List<KartItemDTO> kartItems) {
        this.kartItems = kartItems;
    }
}
