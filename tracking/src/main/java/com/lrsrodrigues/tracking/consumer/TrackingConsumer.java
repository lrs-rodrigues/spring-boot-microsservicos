package com.lrsrodrigues.tracking.consumer;

import com.lrsrodrigues.tracking.entities.Tracking;
import com.lrsrodrigues.tracking.payload.TrackingPayload;
import com.lrsrodrigues.tracking.repositories.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class TrackingConsumer {

    @Autowired
    private TrackingRepository trackingRepository;

    @KafkaListener(groupId = "tracking.group", topics = "tracking")
    public void listen(
            @Payload TrackingPayload trackingPayload,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
            Acknowledgment acknowledgment
    ) {

        Tracking tracking = new Tracking(
                null,
                trackingPayload.getAddressId(),
                trackingPayload.getUuid(),
                trackingPayload.getDeliveryCompany(),
                trackingPayload.getDeliveryPrice());

        trackingRepository.save(tracking);

        acknowledgment.acknowledge();
    }

}
