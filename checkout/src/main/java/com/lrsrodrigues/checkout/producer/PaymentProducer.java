package com.lrsrodrigues.checkout.producer;

import com.lrsrodrigues.checkout.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class PaymentProducer {

    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;

    public void send(Double price, UUID uuid, Integer paymentType) throws ExecutionException, InterruptedException {
        kafkaTemplate.send("payment", new Payment(price, uuid, paymentType)).get();
    }
}
