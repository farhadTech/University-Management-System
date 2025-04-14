package com.example.ums.repository;

import com.example.ums.dto.response.ReviewResponseDTO;
import com.example.ums.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepositroy extends JpaRepository<Review, Long> {
    List<ReviewResponseDTO> findAllProjectedBy();

    @Query("SELECT r FROM Review r WHERE r.id = :id")
    ReviewResponseDTO findProjectedById(@Param("id")Long id);
}
