package com.lrsrodrigues.order.consumer;

import com.lrsrodrigues.order.dto.KartDTO;
import com.lrsrodrigues.order.dto.KartItemDTO;
import com.lrsrodrigues.order.entities.Order;
import com.lrsrodrigues.order.entities.OrderItem;
import com.lrsrodrigues.order.repositories.OrderItemRepository;
import com.lrsrodrigues.order.repositories.OrderRepository;
import com.lrsrodrigues.order.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderConsumer {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @KafkaListener(topics = "${kafka.topic.order}")
    public void receive(
            @Payload KartDTO data,
            @Headers MessageHeaders headers
    ) {
        Integer orderId = data.getOrderId();
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException(orderId));

        List<OrderItem> orderItems = new ArrayList<>();

        for (KartItemDTO item : data.getKartItems()) {
            OrderItem orderItem = new OrderItem(
                    null,
                    item.getQuantity(),
                    item.getPrice(),
                    item.getProductId(),
                    order
            );

            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);
    }
}
