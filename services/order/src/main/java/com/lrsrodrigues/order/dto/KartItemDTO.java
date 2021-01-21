package com.lrsrodrigues.order.dto;

public class KartItemDTO {

    private Integer quantity;
    private Double price;
    private Integer productId;

    public KartItemDTO(Integer quantity, Double price, Integer productId) {
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
