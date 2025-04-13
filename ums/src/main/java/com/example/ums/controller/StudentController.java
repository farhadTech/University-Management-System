package com.example.ums.controller;

import com.example.ums.dto.request.StudentRequestDTO;
import com.example.ums.dto.response.StudentResponseDTO;
import com.example.ums.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO) {
        studentService.addStudent(studentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(studentRequestDTO.toString());
                .body("Student created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody StudentRequestDTO studentRequestDTO) {
        studentService.updateStudent(id, studentRequestDTO);
        return ResponseEntity.status(HttpStatus.OK)
//                .body(studentRequestDTO.toString());
                .body("Student updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Student with id " + id + " not Deleted.");
    }
}
