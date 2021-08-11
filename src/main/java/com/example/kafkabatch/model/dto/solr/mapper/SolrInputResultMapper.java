package com.example.kafkabatch.model.dto.solr.mapper;

import com.example.kafkabatch.model.dto.message.MessageResult;
import com.example.kafkabatch.model.dto.solr.SolrInputResult;
import com.example.kafkabatch.model.dto.solr.SolrInputResultData;

public class SolrInputResultMapper {

    public static SolrInputResult convert(MessageResult messageResult) {
        SolrInputResultData solrInputResultData = SolrInputResultData.builder()
                .version_s(messageResult.getData().getVersion())
                .build();

        return SolrInputResult.builder()
                .absolutePath(messageResult.getAbsolutePath())
                .data(solrInputResultData)
                .filename(messageResult.getFileName())
                .build();
    }
}
