package com.lrsrodrigues.order.dto;

import java.util.List;

public class KartDTO {

    private Integer orderId;
    private List<OrderItemDTO> orderItemList;

    public KartDTO(Integer orderId, List<OrderItemDTO> orderItemList) {
        this.orderId = orderId;
        this.orderItemList = orderItemList;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<OrderItemDTO> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItemDTO> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
