package com.example.kafkabatch.consumer;

import com.example.kafkabatch.model.dto.ciserver.CIServerDto;
import com.example.kafkabatch.model.dto.ciserver.mapper.CIServerDtoMapper;
import com.example.kafkabatch.model.dto.message.SISMessageDto;
import com.example.kafkabatch.model.dto.solr.SolrInputDocument;
import com.example.kafkabatch.model.dto.solr.mapper.SolrInputDocumentMapper;
import com.example.kafkabatch.model.entity.CIServerEntity;
import com.example.kafkabatch.repository.CIServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class SISConsumer {

    @Autowired
    private CIServerRepository ciServerRepository;

    @KafkaListener(topics = "SIS")
    public void sisConsume(List<SISMessageDto> sisMessageDtoList) {
        List<CIServerEntity> ciServerList = ciServerRepository.findAll();
        List<CIServerDto> ciServerDtoList = CIServerDtoMapper.convert(ciServerList);

        Map<String, CIServerDto> mapHostNameCIServerDto = ciServerDtoList.stream()
                .collect(Collectors.toMap(CIServerDto::getHostname, Function.identity()));

        List<SolrInputDocument> solrInputDocumentList = sisMessageDtoList.stream()
                .map(sisMessageDto -> SolrInputDocumentMapper.convert(sisMessageDto, mapHostNameCIServerDto.get(sisMessageDto.getHeader().getHostname())))
                .filter(solrInputDocument -> solrInputDocument.getResult().getFilename() != null)
                .collect(Collectors.toList());
    }
}
