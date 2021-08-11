package com.example.kafkabatch.model.dto.solr.mapper;

import com.example.kafkabatch.model.dto.ciserver.CIServerDto;
import com.example.kafkabatch.model.dto.message.MessageHeader;
import com.example.kafkabatch.model.dto.solr.SolrInputHeader;

public class SolrInputHeaderMapper {

    public static SolrInputHeader convert(MessageHeader messageHeader, CIServerDto ciServerDto) {
        return SolrInputHeader.builder()
                .hostname(messageHeader.getHostname())
                .jobID(messageHeader.getId())
                .scanPluginVersion(messageHeader.getScanPluginVersion())
                .scanPluginName(messageHeader.getScanPluginName())
                .ip(ciServerDto.getIp())
                .vip(ciServerDto.getVip())
                .isPublicIp(ciServerDto.getIsPublicIp())
                .isPublicVip(ciServerDto.getIsPublicVip())
                .isPrivateIp(ciServerDto.getIsPrivateIp())
                .isPrivateVip(ciServerDto.getIsPrivateVip())
                .build();
    }
}
