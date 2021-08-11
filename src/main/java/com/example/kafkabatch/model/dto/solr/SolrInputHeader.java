package com.example.kafkabatch.model.dto.solr;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SolrInputHeader {

    private final String hostname;

    private final String jobID;

    private final String scanPluginVersion;

    private final String scanPluginName;

    private final String ip;

    private final String vip;

    private final Boolean isPublicIp;

    private final Boolean isPublicVip;

    private final Boolean isPrivateIp;

    private final Boolean isPrivateVip;

    @Builder
    public SolrInputHeader(String hostname,
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
