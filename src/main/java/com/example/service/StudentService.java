package com.example.service;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getStudentByUsername(String username) {
        return studentRepository.findByStudentId(username);
    }
    public Student createUser(Student student) {
        student.setName(student.getName());
        student.setStudentId(student.getStudentId());
        student.setEmail(student.getEmail());
        return studentRepository.save(student);

    }

    public boolean checkId(String studentId) {
        return studentRepository.existsByStudentId(studentId);
    }

}
