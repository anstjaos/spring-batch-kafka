package com.example.kafkabatch.model.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageHeader {

    private String hostname;

    private String id;

    private String scanPluginVersion;

    private String scanPluginTopic;

    private String scanPluginName;

    private Long timestamp;

    public MessageHeader(String hostname, String id, String scanPluginVersion, String scanPluginTopic, String scanPluginName, Long timestamp) {
        this.hostname = hostname;
        this.id = id;
        this.scanPluginVersion = scanPluginVersion;
        this.scanPluginTopic = scanPluginTopic;
        this.scanPluginName = scanPluginName;
        this.timestamp = timestamp;
    }
}
