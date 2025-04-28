package com.example.ums.repository;

import com.example.ums.dto.response.CourseResponseDTO;
import com.example.ums.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(""" 
            SELECT c.id as id,
            c.title as title,
            c.departmentName as departmentName,
            c.credits as credits
            FROM Course c
            """)
    List<CourseResponseDTO> findAllCourses();

    @Query("""
            SELECT c.id as id,
            c.title as title,
            c.departmentName as departmentName,
            c.credits as credits
            FROM Course c
            WHERE c.id = :id 
            """)
    CourseResponseDTO findCourseById(@Param("id") Long id);

    @Query("""
            SELECT c.id as id,
            c.title as title,
            c.departmentName as departmentName,
            c.credits as credits
            FROM Course c
            WHERE c.id = :id 
            """)
    Course getCourseById(@Param("id") Long id);

    Set<Course> getCourseByIdIsIn(Set<Long> ids);
}
