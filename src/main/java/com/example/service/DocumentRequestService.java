package com.example.service;

import com.example.model.Admin;
import com.example.model.DocumentRequest;
import com.example.model.Student;
import com.example.repository.DocumentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentRequestService {
    @Autowired
    private DocumentRequestRepository documentRequestRepository;

    public List<DocumentRequest> getAllRequestsForStudent(Student student) {
        return documentRequestRepository.findByStudent(student);
    }
    public List<DocumentRequest> getAllRequestsForAdmin(Admin admin) {
        return documentRequestRepository.findByAdmin(admin);
    }

    public void createDocumentRequest(DocumentRequest documentRequest) {
        documentRequest.setRequestDateTime(LocalDateTime.now());
        documentRequest.setStatus("Pending");
        documentRequestRepository.save(documentRequest);
    }
}
