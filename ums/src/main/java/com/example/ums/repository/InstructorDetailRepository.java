package com.example.ums.repository;

import com.example.ums.dto.response.InstructorDetailResponseDTO;
import com.example.ums.dto.response.InstructorResponseDTO;
import com.example.ums.model.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Long> {
    List<InstructorDetailResponseDTO> findAllProjectedBy();

    InstructorDetailResponseDTO findProjectedById(Long id);
}
