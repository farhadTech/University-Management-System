package com.example.ums.repository;

import com.example.ums.dto.response.CourseResponseDTO;
import com.example.ums.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<CourseResponseDTO> findAllProjectedBy();

    CourseResponseDTO findProjectedById(Long id);

    List<CourseResponseDTO> findAllByInstructorId(Long id);
}
