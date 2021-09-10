package com.example.kafkabatch.model.dto.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SISMessageDto {

    private MessageHeader header;

    private MessageResult result;

    public SISMessageDto() {}

    public SISMessageDto(MessageHeader header, MessageResult result) {
        this.header = header;
        this.result = result;
    }
}
