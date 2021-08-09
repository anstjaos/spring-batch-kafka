package com.example.kafkabatch.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@EnableConfigurationProperties(KafkaProperties.class)
public class KafkaConsumerConfiguration {

    private final KafkaProperties kafkaProperties;

    @Value("${kafka.group-id")
    private String groupId;

    @Value("${kafka.max-fetch-size}")
    private String maxFetchSize;

    public KafkaConsumerConfiguration(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public Map<String, Object> kafkaConsumerConfigs() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        configs.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, maxFetchSize);
        return configs;
    }
}
