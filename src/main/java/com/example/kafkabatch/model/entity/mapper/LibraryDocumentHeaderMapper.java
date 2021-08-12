package com.example.kafkabatch.model.entity.mapper;

import com.example.kafkabatch.model.dto.ciserver.CIServerDto;
import com.example.kafkabatch.model.dto.message.MessageHeader;
import com.example.kafkabatch.model.entity.LibraryDocumentHeader;

import java.util.Optional;

public class LibraryDocumentHeaderMapper {

    public static LibraryDocumentHeader convert(MessageHeader messageHeader, CIServerDto ciServerDto) {
        LibraryDocumentHeader.LibraryDocumentHeaderBuilder libraryDocumentHeaderBuilder = LibraryDocumentHeader.builder()
                .hostname(messageHeader.getHostname())
                .jobID(messageHeader.getId())
                .scanPluginVersion(messageHeader.getScanPluginVersion())
                .scanPluginName(messageHeader.getScanPluginName());

        Optional.ofNullable(ciServerDto)
                .ifPresent(ciServer -> libraryDocumentHeaderBuilder
                        .ip(ciServer.getIp())
                        .vip(ciServerDto.getVip())
                        .isPublicIp(ciServerDto.getIsPublicIp())
                        .isPublicVip(ciServerDto.getIsPublicVip())
                        .isPrivateIp(ciServerDto.getIsPrivateIp())
                        .isPrivateVip(ciServerDto.getIsPrivateVip()));

        return libraryDocumentHeaderBuilder.build();
    }
}
