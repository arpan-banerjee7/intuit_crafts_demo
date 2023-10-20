package com.crafts.profileservice.config;

import com.crafts.profileservice.config.props.KafkaPropsConfig;
import lombok.Getter;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Getter
public class KakfaConfig {

    @Autowired
    private KafkaPropsConfig kafkaPropsConfig;

    @Bean
    public Map<String, Object> getKafkaTemplate() {
        Map<String, Object> props = new HashMap<>();
        props.put("bootstrap.servers", kafkaPropsConfig.getBootstrapServers());
        props.put("group.id", kafkaPropsConfig.getConsumerGroupId());
        props.put("auto.offset.reset", kafkaPropsConfig.getConsumerAutoOffsetReset());
        props.put("key.deserializer", kafkaPropsConfig.getProducerKeySerializer());
        props.put("value.deserializer", kafkaPropsConfig.getProducerValueSerializer());
        props.put("key.serializer", kafkaPropsConfig.getConsumerValueDeserializer());
        props.put("value.serializer", kafkaPropsConfig.getConsumerValueDeserializer());
        return props;
    }

    @Bean(name = "userProfileKafkaTemplate")
    public KafkaTemplate<String, String> userProfileKafkaTemplate() {
        Map<String, Object> props = getKafkaTemplate();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaPropsConfig.getBootstrapServers());
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(props));
    }
}
