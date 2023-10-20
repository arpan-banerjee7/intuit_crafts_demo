package com.crafts.profileservice.producer;

import com.crafts.profileservice.config.props.KafkaPropsConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProfileKakfaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileKakfaProducer.class);
    @Autowired
    private KafkaPropsConfig kafkaPropsConfig;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserProfileKakfaProducer(@Qualifier("userProfileKafkaTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public <T> void send(String message, String eventType) {
        String userProfileTopic = kafkaPropsConfig.getUserProfileKafkaTopic();
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(
                userProfileTopic, null, null, eventType, message);

        LOGGER.info("Sending message to user profile topic: {}, Event type {}", userProfileTopic, eventType);
        kafkaTemplate.send(producerRecord);
    }
}
