package com.example.kafkabatch.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.ChildDocument;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Getter
@SolrDocument(collection = "library_document")
public class LibraryDocumentResult {

    @Field
    private String absolutePath;

    @ChildDocument
    private LibraryDocumentResultData data;

    @Field
    private String filename;

    public LibraryDocumentResult() {}

    @Builder
    public LibraryDocumentResult(String absolutePath, LibraryDocumentResultData data, String filename) {
        this.absolutePath = absolutePath;
        this.data = data;
        this.filename = filename;
    }
}
