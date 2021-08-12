package com.example.kafkabatch.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.ChildDocument;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Getter
@SolrDocument(collection = "library_document")
public class LibraryDocument {

    @Id
    @Field
    private String id;

    @Field
    private String topic;

    @Field
    private String timestamp;

    @ChildDocument
    private LibraryDocumentHeader header;

    @ChildDocument
    private LibraryDocumentResult result;

    public LibraryDocument() {}

    @Builder
    public LibraryDocument(String id, String topic, String timestamp, LibraryDocumentHeader header, LibraryDocumentResult result) {
        this.id = id;
        this.topic = topic;
        this.timestamp = timestamp;
        this.header = header;
        this.result = result;
    }
}
