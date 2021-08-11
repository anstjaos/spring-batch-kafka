package com.example.kafkabatch.model.dto.ciserver;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CIServerDto {

    private final String hostname;

    private final String ip;

    private final String vip;

    private final Boolean isPublicIp;

    private final Boolean isPublicVip;

    private final Boolean isPrivateIp;

    private final Boolean isPrivateVip;

    @Builder
    public CIServerDto(String hostname, String ip, String vip, Boolean isPublicIp, Boolean isPublicVip, Boolean isPrivateIp, Boolean isPrivateVip) {
        this.hostname = hostname;
        this.ip = ip;
        this.vip = vip;
        this.isPublicIp = isPublicIp;
        this.isPublicVip = isPublicVip;
        this.isPrivateIp = isPrivateIp;
        this.isPrivateVip = isPrivateVip;
    }
}
