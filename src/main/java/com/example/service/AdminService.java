package com.example.service;

import com.example.model.Admin;
import com.example.model.DocumentRequest;
import com.example.repository.AdminRepository;
import com.example.repository.DocumentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private DocumentRequestRepository documentRequestRepository;

    public Optional<Admin> getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    public List<DocumentRequest> getAllRequestsForAdmin(Admin admin) {
        return documentRequestRepository.findByAdmin(admin);
    }
}
