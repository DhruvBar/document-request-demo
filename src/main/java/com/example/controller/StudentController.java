package com.example.controller;

import com.example.model.DocumentRequest;
import com.example.model.DocumentRequestBody;
import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.service.DocumentRequestBodyService;
import com.example.service.DocumentRequestService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DocumentRequestService documentRequestService;

    @Autowired
    private DocumentRequestBodyService documentRequestBodyService;
    @Autowired
    private StudentRepository studentRepository;



    @PostMapping("/login")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        try {
            boolean f = studentService.checkId(student.getStudentId());
            if(f)
            {
                student.setName(student.getName());
                student.setEmail(student.getEmail());
                studentRepository.save(student);
                return new ResponseEntity<>(student, null, HttpStatus.OK);
            } else {
                studentRepository.save(student);
                return new ResponseEntity<Student>(student, null, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("/requests")
    public List<DocumentRequest> getAllRequests(@RequestParam String username) {
        Optional<Student> student = studentService.getStudentByUsername(username);
        return student.map(documentRequestService::getAllRequestsForStudent).orElse(Collections.emptyList());
    }

    @PostMapping("/request")
    public ResponseEntity<String> createDocumentRequest(@RequestBody DocumentRequestBody documentRequestBody) {
        Optional<Student> student = studentService.getStudentByUsername(documentRequestBody.getUsername());
        if (student.isPresent()) {
            documentRequestBodyService.saveDocumentRequest(documentRequestBody);
            return ResponseEntity.ok("Document request created successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Student not found.");
        }
    }
}
