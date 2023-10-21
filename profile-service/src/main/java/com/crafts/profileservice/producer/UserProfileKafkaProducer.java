package com.crafts.profileservice.producer;

import com.crafts.profileservice.config.props.KafkaPropsConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserProfileKafkaProducer {
    @Autowired
    private KafkaPropsConfig kafkaPropsConfig;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserProfileKafkaProducer(@Qualifier("userProfileKafkaTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public <T> void send(String message, String eventType) {
        String userProfileTopic = kafkaPropsConfig.getUserProfileKafkaTopic();
        if (null==userProfileTopic) {
            log.error("User profile topic is not available ignoring message {}, Event type {}", message, eventType);
            return;
        }
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(
                userProfileTopic, null, null, eventType, message);
        log.info("Sending message to Topic: {}, Event type {}", userProfileTopic, eventType);
        kafkaTemplate.send(producerRecord);
    }
}
