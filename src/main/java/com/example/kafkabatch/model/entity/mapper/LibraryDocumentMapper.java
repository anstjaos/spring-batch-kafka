package com.example.kafkabatch.model.entity.mapper;

import com.example.kafkabatch.model.dto.ciserver.CIServerDto;
import com.example.kafkabatch.model.dto.message.SISMessageDto;
import com.example.kafkabatch.model.entity.LibraryDocument;
import com.example.kafkabatch.model.entity.LibraryDocumentHeader;
import com.example.kafkabatch.model.entity.LibraryDocumentResult;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LibraryDocumentMapper {

    public static LibraryDocument convert(SISMessageDto sisMessageDto, CIServerDto ciServerDto) {
        String topic = "SIS";
        StringBuilder id = new StringBuilder();
        id.append(topic)
                .append(sisMessageDto.getHeader().getHostname())
                .append(sisMessageDto.getHeader().getScanPluginName())
                .append(sisMessageDto.getResult().getFileName())
                .append(sisMessageDto.getResult().getAbsolutePath());

        LibraryDocumentHeader libraryDocumentHeader = LibraryDocumentHeaderMapper.convert(sisMessageDto.getHeader(), ciServerDto);
        LibraryDocumentResult libraryDocumentResult = LibraryDocumentResultMapper.convert(sisMessageDto.getResult());

        return LibraryDocument.builder()
                .id(getMD5HashString(id.toString()))
                .topic(topic)
                .timestamp(sisMessageDto.getHeader().getTimestamp().toString() + "000")
                .header(libraryDocumentHeader)
                .result(libraryDocumentResult)
                .build();
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
