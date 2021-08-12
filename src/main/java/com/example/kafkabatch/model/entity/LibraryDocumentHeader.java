package com.example.kafkabatch.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Getter
@SolrDocument
public class LibraryDocumentHeader {

    @Field
    private String hostname;

    @Field
    private String jobID;

    @Field
    private String scanPluginVersion;

    @Field
    private String scanPluginName;

    @Field
    private String ip;

    @Field
    private String vip;

    @Field
    private Boolean isPublicIp;

    @Field
    private Boolean isPublicVip;

    @Field
    private Boolean isPrivateIp;

    @Field
    private Boolean isPrivateVip;

    public LibraryDocumentHeader() {}

    @Builder
    public LibraryDocumentHeader(String hostname,
                                 String jobID,
                                 String scanPluginVersion,
                                 String scanPluginName,
                                 String ip, String vip,
                                 Boolean isPublicIp,
                                 Boolean isPublicVip,
                                 Boolean isPrivateIp,
                                 Boolean isPrivateVip) {
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
    }
}
