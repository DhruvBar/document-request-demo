package com.example.service;

import com.example.model.*;
import com.example.repository.DocumentRepository;
import com.example.repository.DocumentRequestRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentRequestBodyService {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DocumentRequestRepository documentRequestRepository;




    public void saveDocumentRequest(DocumentRequestBody documentRequestBody)
    {


        Optional<Student> studentOptional = studentRepository.findByStudentId(documentRequestBody.getUsername());
        Student student = studentOptional.get();


        for(DocumentRequestData documentRequestData: documentRequestBody.getDocumentRequestDataList())
        {
            Optional<Document> documentOptional = documentRepository.findById(documentRequestData.getDocumentId());
            int copies = documentRequestData.getCopies();
            if(documentOptional.isPresent()){
                Document document = documentOptional.get();

                DocumentRequest documentRequest = new DocumentRequest();
                documentRequest.setDocument(document);
                documentRequest.setStudent(student);
                documentRequest.setCopies(copies);
                documentRequest.setPrice(document.getPrice());
                documentRequest.setTotalPrice(copies*document.getPrice());
                documentRequest.setRequestDateTime(LocalDateTime.now());
                documentRequest.setStatus("Pending");
                documentRequestRepository.save(documentRequest);

            }
        }

    }

}
