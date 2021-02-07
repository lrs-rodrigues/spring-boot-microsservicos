package com.lrsrodrigues.order.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConfig {

    @Bean
    public SeekToCurrentErrorHandler errorHandler(KafkaTemplate<Object, Object> template) {
        return new SeekToCurrentErrorHandler(
                new DeadLetterPublishingRecoverer(template), new FixedBackOff(1000L, 2));
    }

    @Bean
    public RecordMessageConverter converter() {
        return new StringJsonMessageConverter();
    }


    @Bean
    public NewTopic topic() {
        return new NewTopic("order", 1, (short) 1);
    }

    @Bean
    public NewTopic dlt() {
        return new NewTopic("order.DLT", 1, (short) 1);
    }
}
