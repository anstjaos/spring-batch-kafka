package com.example.kafkabatch.consumer;

import com.example.kafkabatch.model.dto.ciserver.CIServerDto;
import com.example.kafkabatch.model.dto.ciserver.mapper.CIServerDtoMapper;
import com.example.kafkabatch.model.dto.message.SISMessageDto;
import com.example.kafkabatch.model.entity.CIServerEntity;
import com.example.kafkabatch.model.entity.LibraryDocument;
import com.example.kafkabatch.model.entity.mapper.LibraryDocumentMapper;
import com.example.kafkabatch.repository.CIServerRepository;
import com.example.kafkabatch.repository.solr.LibraryDocumentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SISConsumer {

    private final CIServerRepository ciServerRepository;
    private final LibraryDocumentRepository libraryDocumentRepository;

    public SISConsumer(CIServerRepository ciServerRepository, LibraryDocumentRepository libraryDocumentRepository) {
        this.ciServerRepository = ciServerRepository;
        this.libraryDocumentRepository = libraryDocumentRepository;
    }

    @KafkaListener(topics = "SIS")
    public void sisConsume(List<SISMessageDto> sisMessageDtoList) {
        List<CIServerEntity> ciServerList = ciServerRepository.findAll();
        List<CIServerDto> ciServerDtoList = CIServerDtoMapper.convert(ciServerList);

        Map<String, CIServerDto> mapHostNameCIServerDto = new HashMap<>();
        ciServerDtoList.forEach(ciServerDto -> mapHostNameCIServerDto.put(ciServerDto.getHostname(), ciServerDto));

        List<LibraryDocument> libraryDocumentList = sisMessageDtoList.stream()
                .map(sisMessageDto -> LibraryDocumentMapper.convert(sisMessageDto, mapHostNameCIServerDto.get(sisMessageDto.getHeader().getHostname())))
                .filter(libraryDocument -> libraryDocument.getFilename() != null)
                .collect(Collectors.toList());

        log.debug("[PROCESS CHECKER] number of documents: " + libraryDocumentList.size());

        if (libraryDocumentList.size() != 0) {
            libraryDocumentRepository.saveAll(libraryDocumentList);
        } else {
            log.debug("RDD is Empty!");
        }
    }
}
