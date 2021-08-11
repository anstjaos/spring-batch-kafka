package com.example.kafkabatch.model.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "ciServer")
public class CIServerEntity {

    @Id
    private String hostname;

    private String ip;

    private String vip;

    private Boolean isPublicIp;

    private Boolean isPublicVip;
}
