package com.example.ums.service;

import com.example.ums.dto.request.CourseRequestDTO;
import com.example.ums.dto.response.CourseResponseDTO;
import com.example.ums.model.Course;

import java.util.List;

public interface CourseService {
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO getCourseById(Long id);
    void addCourse(CourseRequestDTO courseRequestDTO);
    void updateCourse(Long id, CourseRequestDTO courseRequestDTO);
    void deleteCourse(Long id);
    List<CourseResponseDTO> getAllCoursesByInstructorId(Long id);
}

