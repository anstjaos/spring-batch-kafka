package com.example.kafkabatch.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
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

    @Field("header.jobID")
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

    @Field("result.absolutePath")
    private String absolutePath;

    @Field("result.filename")
    private String filename;

    @Field("result.data.version_s")
    private String version;

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
                           String absolutePath,
                           String filename,
                           String version) {
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
        this.absolutePath = absolutePath;
        this.filename = filename;
        this.version = version;
    }
}
