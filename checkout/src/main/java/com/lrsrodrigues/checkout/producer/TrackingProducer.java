package com.lrsrodrigues.checkout.producer;

import com.lrsrodrigues.checkout.entities.Tracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class TrackingProducer {

    @Autowired
    private KafkaTemplate<String, Tracking> kafkaTemplate;

    public void send(Integer addressId, UUID uuid, String deliveryCompany, Double deliveryPrice) throws ExecutionException, InterruptedException {
        kafkaTemplate.send("tracking", new Tracking(addressId, uuid, deliveryCompany, deliveryPrice)).get();
    }
}
