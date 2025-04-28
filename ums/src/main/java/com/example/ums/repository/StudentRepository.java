package com.example.ums.repository;

import com.example.ums.dto.response.StudentResponseDTO;
import com.example.ums.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("""
            SELECT s.id as id,
            s.fullName as fullName,
            s.username as username
            FROM Student s
            """)
    List<StudentResponseDTO> findAllStudents();

    @Query("""
            SELECT s.id as id,
            s.fullName as fullName,
            s.username as username
            FROM Student s
            WHERE s.id = :id
            """)
    StudentResponseDTO findStudentById(@Param("id") Long id);

    @Query("""
            SELECT s.id as id,
            s.fullName as fullName,
            s.username as username
            FROM Student s
            WHERE s.id = :id 
            """)
    Student getStudentById(@Param("id") Long id);
}
