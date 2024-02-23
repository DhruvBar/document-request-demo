package com.example.service;

import com.example.model.Admin;
import com.example.model.Document;
import com.example.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public void addDocument(Document document, Admin admin) {
        document.setAdmin(admin);
        documentRepository.save(document);
    }
}
