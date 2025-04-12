package com.example.ums.controller;

import com.example.ums.dto.request.StudentRequestDTO;
import com.example.ums.dto.response.StudentResponseDTO;
import com.example.ums.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        studentService.addStudent(studentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentRequestDTO.toString());
//                .body("Student created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(Long id, @RequestBody StudentRequestDTO studentRequestDTO) {
        studentService.updateStudent(id, studentRequestDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentRequestDTO.toString());
//                .body("Student updated successfully");
    }
}
