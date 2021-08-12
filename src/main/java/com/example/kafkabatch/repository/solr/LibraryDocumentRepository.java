package com.example.kafkabatch.repository.solr;

import com.example.kafkabatch.model.entity.LibraryDocument;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface LibraryDocumentRepository extends SolrCrudRepository<LibraryDocument, String> {
}
