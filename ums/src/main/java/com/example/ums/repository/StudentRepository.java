package com.example.ums.repository;

import com.example.ums.dto.response.StudentResponseDTO;
import com.example.ums.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<StudentResponseDTO> findAllProjectedBy();

    StudentResponseDTO findProjectedById(Long id);
}
