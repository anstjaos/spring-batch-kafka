package com.example.kafkabatch.model.dto;

import com.example.kafkabatch.model.message.MessageHeader;
import com.example.kafkabatch.model.message.MessageResult;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsumeMessageDTO {

    private MessageHeader header;

    private MessageResult result;

    public ConsumeMessageDTO(MessageHeader header, MessageResult result) {
        this.header = header;
        this.result = result;
    }
}
