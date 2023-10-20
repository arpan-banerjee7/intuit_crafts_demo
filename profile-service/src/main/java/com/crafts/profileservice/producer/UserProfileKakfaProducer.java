package com.crafts.profileservice.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class UserProfileKakfaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileKakfaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${user.profile.kafka.topic}")
    private String userProfileTopic;

    public UserProfileKakfaProducer(@Qualifier("userProfileKafkaTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public <T> void send(String message, String eventType) {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(
                userProfileTopic, null, null, eventType, message);

        LOGGER.info("Sending message to : {}, Event type {}", userProfileTopic, eventType);
        kafkaTemplate.send(producerRecord);
    }
}
