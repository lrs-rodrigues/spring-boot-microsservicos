package com.lrsrodrigues.checkout.entities;

public class KartItem {

    private Integer quantity;
    private Double price;
    private Integer productId;

    public KartItem(Integer quantity, Double price, Integer productId) {
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

    public String toString() {
        return "KartItem [quantity=" + quantity + ", price=" +  price + ", productId=" + productId + "]";
    }
}
