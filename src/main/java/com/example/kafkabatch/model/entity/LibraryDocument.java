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
    @Field("id")
    private String id;

    @Field("topic")
    private String topic;

    @Field("timestamp")
    private String timestamp;

    @Field("header.hostname")
    private String hostname;

    @Field("header.id")
    private String jobID;

    @Field("header.scanPluginVersion")
    private String scanPluginVersion;

    @Field("header.scanPluginName")
    private String scanPluginName;

    @Field("header.ip")
    private String ip;

    @Field("header.vip")
    private String vip;

    @Field("header.isPublicIp")
    private Boolean isPublicIp;

    @Field("header.isPublicVip")
    private Boolean isPublicVip;

    @Field("header.isPrivateIp")
    private Boolean isPrivateIp;

    @Field("header.isPrivateVip")
    private Boolean isPrivateVip;


    @ChildDocument
    private LibraryDocumentResult result;

    public LibraryDocument() {}

    @Builder
    public LibraryDocument(String id,
                           String topic,
                           String timestamp,
                           String hostname,
                           String jobID,
                           String scanPluginVersion,
                           String scanPluginName,
                           String ip,
                           String vip,
                           Boolean isPublicIp,
                           Boolean isPublicVip,
                           Boolean isPrivateIp,
                           Boolean isPrivateVip,
                           LibraryDocumentResult result) {
        this.id = id;
        this.topic = topic;
        this.timestamp = timestamp;
        this.hostname = hostname;
        this.jobID = jobID;
        this.scanPluginVersion = scanPluginVersion;
        this.scanPluginName = scanPluginName;
        this.ip = ip;
        this.vip = vip;
        this.isPublicIp = isPublicIp;
        this.isPublicVip = isPublicVip;
        this.isPrivateIp = isPrivateIp;
        this.isPrivateVip = isPrivateVip;
        this.result = result;
    }
}
