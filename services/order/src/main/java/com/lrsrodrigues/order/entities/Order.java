package com.lrsrodrigues.order.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lrsrodrigues.order.entities.enums.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date moment;

    private Integer orderStatus;

    private Integer userId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItem = new ArrayList<>();

    public Order() { }

    public Order(Integer id, Date moment, Integer orderStatus, Integer userId) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.userId = userId;
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

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItemsBase(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order orderBase = (Order) o;
        return Objects.equals(id, orderBase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}