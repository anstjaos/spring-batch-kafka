package com.example.kafkabatch.model.entity.mapper;

import com.example.kafkabatch.model.dto.ciserver.CIServerDto;
import com.example.kafkabatch.model.dto.message.MessageHeader;
import com.example.kafkabatch.model.dto.message.MessageResult;
import com.example.kafkabatch.model.dto.message.SISMessageDto;
import com.example.kafkabatch.model.entity.LibraryDocument;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Slf4j
public class LibraryDocumentMapper {

    public static LibraryDocument convert(SISMessageDto sisMessageDto, CIServerDto ciServerDto) {
        String topic = "SIS";

        StringBuilder id = new StringBuilder();
        MessageHeader messageHeader = sisMessageDto.getHeader();
        MessageResult messageResult = sisMessageDto.getResult();
        id.append(topic)
                .append(messageHeader.getHostname())
                .append(messageHeader.getScanPluginName())
                .append(messageResult.getFilename())
                .append(messageResult.getAbsolutePath());

        LibraryDocument.LibraryDocumentBuilder builder = LibraryDocument.builder()
                .id(getMD5HashString(id.toString()))
                .topic(topic)
                .timestamp(messageHeader.getTimestamp().toString() + "000")
                .hostname(messageHeader.getHostname())
                .jobID(messageHeader.getId())
                .scanPluginVersion(messageHeader.getScanPluginVersion())
                .scanPluginName(messageHeader.getScanPluginName())
                .absolutePath(messageResult.getAbsolutePath())
                .filename(messageResult.getFilename())
                .version(messageResult.getData().getVersion());

        Optional.ofNullable(ciServerDto)
                .ifPresent(ciServer -> builder
                        .ip(ciServer.getIp())
                        .vip(ciServerDto.getVip())
                        .isPublicIp(ciServerDto.getIsPublicIp())
                        .isPublicVip(ciServerDto.getIsPublicVip())
                        .isPrivateIp(ciServerDto.getIsPrivateIp())
                        .isPrivateVip(ciServerDto.getIsPrivateVip()));

        return builder.build();
    }

    private static String getMD5HashString(String input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(input.getBytes());
            BigInteger bigInt = new BigInteger(1, digest);
            return bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return input;
    }
}
