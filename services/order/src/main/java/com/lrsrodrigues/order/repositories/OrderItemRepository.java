package com.lrsrodrigues.order.repositories;

import com.lrsrodrigues.order.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository  extends JpaRepository<OrderItem, Integer> {
}
