package com.example.ums.controller;

import com.example.ums.dto.request.StudentRequestDTO;
import com.example.ums.dto.response.StudentResponseDTO;
import com.example.ums.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void createStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        studentService.addStudent((studentRequestDTO));
    }

    @PutMapping
    public void updateStudent(Long id, @RequestBody StudentRequestDTO studentRequestDTO) {
        studentService.updateStudent(id, studentRequestDTO);
    }
}
