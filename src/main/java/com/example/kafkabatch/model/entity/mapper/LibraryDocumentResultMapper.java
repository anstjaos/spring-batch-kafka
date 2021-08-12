package com.example.kafkabatch.model.entity.mapper;

import com.example.kafkabatch.model.dto.message.MessageResult;
import com.example.kafkabatch.model.entity.LibraryDocumentResult;
import com.example.kafkabatch.model.entity.LibraryDocumentResultData;

public class LibraryDocumentResultMapper {

    public static LibraryDocumentResult convert(MessageResult messageResult) {
        LibraryDocumentResultData solrInputResultData = LibraryDocumentResultData.builder()
                .version_s(messageResult.getData().getVersion())
                .build();

        return LibraryDocumentResult.builder()
                .absolutePath(messageResult.getAbsolutePath())
                .data(solrInputResultData)
                .filename(messageResult.getFileName())
                .build();
    }
}
