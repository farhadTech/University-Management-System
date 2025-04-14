package com.example.ums.service.serviceImpl;

import com.example.ums.dto.request.ReviewRequestDTO;
import com.example.ums.dto.response.ReviewResponseDTO;
import com.example.ums.model.Review;
import com.example.ums.repository.ReviewRepositroy;
import com.example.ums.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
   private final ReviewRepositroy reviewRepository;

    @Override
    public List<ReviewResponseDTO> getAllReviews() {
        return reviewRepository.findAllProjectedBy();
    }

    @Override
    public ReviewResponseDTO getReviewById(Long id) {
        ReviewResponseDTO reviewResponseDTO = reviewRepository.findProjectedById(id);
        if (Objects.isNull(reviewResponseDTO)) {
            throw new RuntimeException("Review not found with id: " + id);
        }
        return reviewResponseDTO;
    }

    @Override
    public void addReview(ReviewRequestDTO reviewRequestDTO) {
        Review review = new Review();
        review.setComment(reviewRequestDTO.comment());
        review.setRating(reviewRequestDTO.rating());
        reviewRepository.save(review);
    }

    @Override
    public void updateReview(Long id, ReviewRequestDTO reviewRequestDTO) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
        review.setComment(reviewRequestDTO.comment());
        review.setRating(reviewRequestDTO.rating());
        reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
