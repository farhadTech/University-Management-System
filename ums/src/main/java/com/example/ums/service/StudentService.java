package com.example.ums.service;

import com.example.ums.dto.request.StudentRequestDTO;
import com.example.ums.dto.response.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> getAllStudents();
    StudentResponseDTO getStudentById(Long id);
    void addStudent(StudentRequestDTO studentRequestDTO);
    void updateStudent(Long id, StudentRequestDTO studentRequestDTO);
    void deleteStudent(Long id);
}
