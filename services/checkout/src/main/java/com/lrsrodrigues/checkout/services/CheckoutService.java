package com.lrsrodrigues.checkout.services;

import com.lrsrodrigues.checkout.dto.CheckoutDTO;
import com.lrsrodrigues.checkout.entities.KartItem;
import com.lrsrodrigues.checkout.entities.Order;
import com.lrsrodrigues.checkout.producer.OrderProducer;
import com.lrsrodrigues.checkout.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CheckoutService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProducer orderProducer;

    public Order insert(CheckoutDTO data) {
        Order order = new Order(null, new Date(), 1, data.getUserId());

        order = orderRepository.save(order);

        orderProducer.send(order.getId(), data.getKartItems());

        return order;
    }
}
