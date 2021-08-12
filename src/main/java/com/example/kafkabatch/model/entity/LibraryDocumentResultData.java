package com.example.kafkabatch.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Getter
@SolrDocument
public class LibraryDocumentResultData {

    @Field
    private String version_s;

    public LibraryDocumentResultData() {}

    @Builder
    public LibraryDocumentResultData(String version_s) {
        this.version_s = version_s;
    }
}
