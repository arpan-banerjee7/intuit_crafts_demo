package com.crafts.profileservice.consumer;

import com.crafts.profileservice.config.props.KafkaPropsConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserProfileKafkaConsumer {
    @Autowired
    private KafkaPropsConfig kafkaPropsConfig;

    @KafkaListener(topics = "#{kafkaPropsConfig.getUserProfileKafkaTopic()}", groupId = "#{userProfileKafkaTopic.getConsumerGroupId()}")
    public void consume(ConsumerRecord<String, String> message) {
        log.info("Received message from Topic: {}, Event type: {}, Message: {}", message.topic(), message.key(), message.value());
        // Add your custom logic here
    }
}
