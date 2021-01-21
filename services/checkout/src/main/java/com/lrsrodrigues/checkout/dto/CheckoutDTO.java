package com.lrsrodrigues.checkout.dto;

import java.util.Date;
import java.util.List;

public class CheckoutDTO {

    private Integer orderStatus;
    private Integer userId;
    private List<KartItemDTO> kartItems;

    public CheckoutDTO(Integer orderStatus, Integer userId, List<KartItemDTO> kartItems) {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<KartItemDTO> getKartItems() {
        return kartItems;
    }

    public void setKartItems(List<KartItemDTO> kartItems) {
        this.kartItems = kartItems;
    }
}
