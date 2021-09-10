package com.example.kafkabatch.model.dto.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResult {

    private String absolutePath;

    private MessageResultData data;

    private String filename;

    public MessageResult() {}

    public MessageResult(String absolutePath, MessageResultData data, String filename) {
        this.absolutePath = absolutePath;
        this.data = data;
        this.filename = filename;
    }
}
