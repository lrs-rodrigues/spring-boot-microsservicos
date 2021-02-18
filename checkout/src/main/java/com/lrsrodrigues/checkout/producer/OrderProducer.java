package com.lrsrodrigues.checkout.producer;

import com.lrsrodrigues.checkout.entities.Kart;
import com.lrsrodrigues.checkout.entities.KartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, Kart> kafkaTemplate;

    public void send(UUID uuid, Integer userId, List<KartItem> kartItems) throws ExecutionException, InterruptedException {
        kafkaTemplate.send("order", new Kart(uuid, userId, kartItems)).get();
    }
}
