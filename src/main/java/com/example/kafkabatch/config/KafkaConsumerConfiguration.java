package com.example.kafkabatch.config;

import com.example.kafkabatch.model.dto.message.SISMessageDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfiguration {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${kafka.group-id}")
    private String groupId;

    @Value("${kafka.max-fetch-size}")
    private String maxFetchSize;


    @Bean
    public Map<String, Object> kafkaConsumerConfigs() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        configs.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, maxFetchSize);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return configs;
    }

    @Bean
    public ConsumerFactory<String, SISMessageDto> kafkaConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(kafkaConsumerConfigs(), new StringDeserializer(), new JsonDeserializer<>(SISMessageDto.class, false));
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, SISMessageDto>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, SISMessageDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(kafkaConsumerFactory());
        factory.setBatchListener(true);

        ContainerProperties containerProperties = factory.getContainerProperties();
        containerProperties.setAckMode(ContainerProperties.AckMode.BATCH);
        containerProperties.setIdleBetweenPolls(4000);
        return factory;
    }

}
