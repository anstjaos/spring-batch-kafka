package com.example.kafkabatch.consumer;

import com.example.kafkabatch.model.dto.message.SISMessageDto;
import com.example.kafkabatch.model.entity.CIServerEntity;
import com.example.kafkabatch.repository.CIServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SISConsumer {

    @Autowired
    private CIServerRepository ciServerRepository;

    @KafkaListener(topics = "SIS")
    public void sisConsume(List<SISMessageDto> sisMessageDtoList) {
        List<CIServerEntity> ciServerList = ciServerRepository.findAll();
    }
}
