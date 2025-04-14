package com.example.ums.service;

import com.example.ums.dto.request.ReviewRequestDTO;
import com.example.ums.dto.response.ReviewResponseDTO;
import com.example.ums.model.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewResponseDTO> getAllReviews();
    ReviewResponseDTO getReviewById(Long id);
    void addReview(ReviewRequestDTO reviewRequestDTO);
    void updateReview(Long id, ReviewRequestDTO reviewRequestDTO);
    void deleteReview(Long id);
}
