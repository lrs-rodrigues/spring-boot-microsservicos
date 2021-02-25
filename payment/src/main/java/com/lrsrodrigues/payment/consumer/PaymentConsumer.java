package com.lrsrodrigues.payment.consumer;

import com.lrsrodrigues.payment.entities.Payment;
import com.lrsrodrigues.payment.payload.PaymentPayload;
import com.lrsrodrigues.payment.repositories.PaymentRepository;
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
public class PaymentConsumer {

    @Autowired
    private PaymentRepository paymentRepository;

    @KafkaListener(groupId = "payment.group", topics = "payment")
    public void listen(
            @Payload PaymentPayload paymentPayload,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
            Acknowledgment acknowledgment
    ) {

        Payment payment = new Payment(
                null,
                new Date(),
                paymentPayload.getPrice(),
                paymentPayload.getUuid(),
                paymentPayload.getPaymentType());

        paymentRepository.save(payment);

        acknowledgment.acknowledge();
    }

}
