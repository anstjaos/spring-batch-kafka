package com.example.kafkabatch.model.dto.solr;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SolrInputResult {

    private final String absolutePath;

    private final SolrInputResultData data;

    private final String filename;

    @Builder
    public SolrInputResult(String absolutePath, SolrInputResultData data, String filename) {
        this.absolutePath = absolutePath;
        this.data = data;
        this.filename = filename;
    }
}
