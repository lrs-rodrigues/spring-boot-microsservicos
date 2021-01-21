package com.lrsrodrigues.order.services;

import com.lrsrodrigues.order.entities.Order;
import com.lrsrodrigues.order.repositories.OrderItemRepository;
import com.lrsrodrigues.order.repositories.OrderRepository;
import com.lrsrodrigues.order.services.exceptions.ResourceNotFoundException;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<Order> findAll() {
        List<Order> orders = orderRepository.findAll();

        return orders;
    }

    public Order findById(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return order;
    }
}
