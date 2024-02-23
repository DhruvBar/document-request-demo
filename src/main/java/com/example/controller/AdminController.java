package com.example.controller;

import com.example.model.Admin;
import com.example.model.Document;
import com.example.model.DocumentRequest;
import com.example.service.AdminService;
import com.example.service.DocumentRequestService;
import com.example.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private DocumentService documentService;
    @Autowired
    private AdminService adminService;

    @Autowired
    private DocumentRequestService documentRequestService;

    @GetMapping("/requests")
    public List<DocumentRequest> getAllRequests(@RequestParam String username) {
        Optional<Admin> admin = adminService.getAdminByUsername(username);
        return admin.map(documentRequestService::getAllRequestsForAdmin).orElse(Collections.emptyList());
    }

    @PostMapping("/documents")
    public ResponseEntity<String> addDocument(@RequestParam String username,
                                              @RequestBody Document document) {
        Optional<Admin> admin = adminService.getAdminByUsername(username);
        if (admin.isPresent()) {
            documentService.addDocument(document, admin.get());
            return ResponseEntity.ok("Document added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Admin not found.");
        }
    }
}
