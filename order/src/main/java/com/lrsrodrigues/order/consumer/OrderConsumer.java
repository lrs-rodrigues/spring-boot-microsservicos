package com.lrsrodrigues.order.consumer;

import com.lrsrodrigues.order.entities.Kart;
import com.lrsrodrigues.order.entities.KartItem;
import com.lrsrodrigues.order.entities.Order;
import com.lrsrodrigues.order.entities.OrderItem;
import com.lrsrodrigues.order.repositories.OrderItemRepository;
import com.lrsrodrigues.order.repositories.OrderRepository;
import com.lrsrodrigues.order.services.exceptions.ResourceNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class OrderConsumer {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @KafkaListener(groupId = "order.group", topics = "order")
    public void listen(
            @Payload Kart kart,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
            Acknowledgment acknowledgment
    ) {
        UUID uuid = kart.getUuid();

        Order order = new Order(null, new Date(), 1, kart.getUserId(), uuid);

        orderRepository.save(order);

        List<OrderItem> orderItems = new ArrayList<>();

        for (KartItem item : kart.getKartItems()) {
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

        acknowledgment.acknowledge();
    }

}
