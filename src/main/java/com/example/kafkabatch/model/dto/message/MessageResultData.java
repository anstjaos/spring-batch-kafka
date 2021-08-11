package com.example.kafkabatch.model.dto.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResultData {

    private String timestamp;

    private String version;

    private String hash;

    public MessageResultData(String timestamp, String version, String hash) {
        this.timestamp = timestamp;
        this.version = version;
        this.hash = hash;
    }
}
