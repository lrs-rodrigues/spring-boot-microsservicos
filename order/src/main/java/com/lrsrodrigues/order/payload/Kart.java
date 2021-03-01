package com.lrsrodrigues.order.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Kart {

    @JsonProperty("uuid")
    private UUID uuid;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("kartItems")
    private List<KartItem> kartItems;

    public Kart() {}

    public Kart(UUID uuid, Integer userId, List<KartItem> kartItems) {
        this.uuid = uuid;
        this.userId = userId;
        this.kartItems = kartItems;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public List<KartItem> getKartItems() {
        return kartItems;
    }

    public void setKartItems(List<KartItem> kartItems) {
        this.kartItems = kartItems;
    }

    public String toString() {
        return "Kart [uuid=" + uuid + ", userId=" + userId + ", kartItems=" +  kartItems + "]";
    }
}
