package com.example.repository;

import com.example.model.Admin;
import com.example.model.DocumentRequest;
import com.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRequestRepository extends JpaRepository<DocumentRequest, Long> {
    List<DocumentRequest> findByStudent(Student student);
    List<DocumentRequest> findByAdmin(Admin admin);

}
