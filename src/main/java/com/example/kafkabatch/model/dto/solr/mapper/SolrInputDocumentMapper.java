package com.example.kafkabatch.model.dto.solr.mapper;

import com.example.kafkabatch.model.dto.ciserver.CIServerDto;
import com.example.kafkabatch.model.dto.message.SISMessageDto;
import com.example.kafkabatch.model.dto.solr.SolrInputDocument;
import com.example.kafkabatch.model.dto.solr.SolrInputHeader;
import com.example.kafkabatch.model.dto.solr.SolrInputResult;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SolrInputDocumentMapper {

    public static SolrInputDocument convert(SISMessageDto sisMessageDto, CIServerDto ciServerDto) {
        String topic = "SIS";
        StringBuilder id = new StringBuilder();
        id.append(topic)
                .append(sisMessageDto.getHeader().getHostname())
                .append(sisMessageDto.getHeader().getScanPluginName())
                .append(sisMessageDto.getResult().getFileName())
                .append(sisMessageDto.getResult().getAbsolutePath());

        SolrInputHeader solrInputHeader = SolrInputHeaderMapper.convert(sisMessageDto.getHeader(), ciServerDto);
        SolrInputResult solrInputResult = SolrInputResultMapper.convert(sisMessageDto.getResult());

        return SolrInputDocument.builder()
                .id(getMD5HashString(id.toString()))
                .topic(topic)
                .timestamp(sisMessageDto.getHeader().getTimestamp().toString() + "000")
                .header(solrInputHeader)
                .result(solrInputResult)
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
