package com.example.ums.repository;

import com.example.ums.dto.response.InstructorResponseDTO;
import com.example.ums.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    List<InstructorResponseDTO> findAllProjectedBy();

    InstructorResponseDTO findProjectedById(Long id);
}
