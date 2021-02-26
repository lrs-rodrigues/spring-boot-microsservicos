package com.lrsrodrigues.tracking.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_tracking")
public class Tracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer addressId;

    private UUID uuid;

    private String deliveryCompany;

    private Double deliveryPrice;

    public Tracking() {}

    public Tracking(Integer id, Integer addressId, UUID uuid, String deliveryCompany, Double deliveryPrice) {
        this.id = id;
        this.addressId = addressId;
        this.uuid = uuid;
        this.deliveryCompany = deliveryCompany;
        this.deliveryPrice = deliveryPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tracking tracking = (Tracking) o;
        return Objects.equals(id, tracking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
