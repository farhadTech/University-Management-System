package com.example.ums.service;

import com.example.ums.dto.request.CourseRequestDTO;
import com.example.ums.dto.response.CourseResponseDTO;
import com.example.ums.model.Course;

import java.util.List;

public interface CourseService {
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO getCourseById(Long id);
    Course createCourse(CourseRequestDTO courseRequestDTO);
    Course updateCourse(Long id, CourseRequestDTO courseRequestDTO);
    String deleteCourse(Long id);
}

