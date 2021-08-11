package com.example.kafkabatch.model.dto.solr;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class SolrInputDocument {

    private final String id;

    private final String topic;

    private final String timestamp;

    private final SolrInputHeader header;

    private final SolrInputResult result;

    @Builder
    public SolrInputDocument(String id, String topic, String timestamp, SolrInputHeader header, SolrInputResult result) {
        this.id = id;
        this.topic = topic;
        this.timestamp = timestamp;
        this.header = header;
        this.result = result;
    }
}
