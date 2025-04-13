package com.example.ums.controller;

import com.example.ums.dto.request.CourseRequestDTO;
import com.example.ums.dto.response.CourseResponseDTO;
import com.example.ums.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/courses")
@RestController
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> findAllCourse() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable Long id){
        CourseResponseDTO courseResponseDTO = courseService.getCourseById(id);
        return new ResponseEntity<>(courseResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCourse(@RequestBody CourseRequestDTO courseRequestDTO) {
        courseService.addCourse(courseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Course created successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable Long id, @RequestBody CourseRequestDTO courseRequestDTO) {
        courseService.updateCourse(id, courseRequestDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Course updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<List<CourseResponseDTO>> getAllCourseByInstructorId(@PathVariable Long id) {
        return new ResponseEntity<>(courseService.getAllCoursesByInstructorId(id), HttpStatus.OK);
    }
}
















