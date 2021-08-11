package com.example.kafkabatch.model.dto.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResult {

    private String absolutePath;

    private MessageResultData data;

    private String fileName;

    public MessageResult(String absolutePath, MessageResultData data, String fileName) {
        this.absolutePath = absolutePath;
        this.data = data;
        this.fileName = fileName;
    }
}
