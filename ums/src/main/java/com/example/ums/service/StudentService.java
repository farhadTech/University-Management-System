package com.example.ums.service;

import com.example.ums.dto.request.StudentRequestDTO;
import com.example.ums.dto.response.StudentResponseDTO;
import com.example.ums.model.Student;
import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> getAllStudents();
    StudentResponseDTO getStudentById(Long id);
    Student createStudent(StudentRequestDTO studentRequestDTO);
    Student updateStudent(Long id, StudentRequestDTO studentRequestDTO);
    String deleteStudent(Long id);
}
