package com.example.kafkabatch.model.dto.solr;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SolrInputResultData {

    private final String version_s;

    @Builder
    public SolrInputResultData(String version_s) {
        this.version_s = version_s;
    }
}
