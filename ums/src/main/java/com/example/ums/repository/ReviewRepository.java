package com.example.ums.repository;

import com.example.ums.dto.response.ReviewResponseDTO;
import com.example.ums.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("""
            SELECT r
            FROM Review r
            """)
    List<ReviewResponseDTO> findAllReviews();

    @Query("""
            SELECT r 
            FROM Review r 
            WHERE r.id = :id 
            """)
    ReviewResponseDTO findReviewById(@Param("id")Long id);

    @Query("""
            SELECT r 
            FROM Review r 
            WHERE r.id = :id 
            """)
    Review getReviewById(Long id);
}
