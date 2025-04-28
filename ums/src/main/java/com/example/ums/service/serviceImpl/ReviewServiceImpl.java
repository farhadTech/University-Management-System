package com.example.ums.service.serviceImpl;

import com.example.ums.common.exception.IDNotFoundException;
import com.example.ums.dto.request.ReviewRequestDTO;
import com.example.ums.dto.response.ReviewResponseDTO;
import com.example.ums.model.Review;
import com.example.ums.repository.ReviewRepository;
import com.example.ums.service.ReviewService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewServiceImpl implements ReviewService {
   private ReviewRepository reviewRepository;

   public ReviewServiceImpl(ReviewRepository reviewRepository) {
       this.reviewRepository = reviewRepository;
   }

    @Override
    public List<ReviewResponseDTO> getAllReviews() {
        return reviewRepository.findAllReviews();
    }

    @Override
    public ReviewResponseDTO getReviewById(Long id) {
        ReviewResponseDTO reviewResponseDTO = reviewRepository.findReviewById(id);
        if(reviewResponseDTO == null){
            throw new IDNotFoundException("ID not found for id: " + id);
        }

        return reviewResponseDTO;
    }

    @Override
    public Review createReview(ReviewRequestDTO reviewRequestDTO) {
        Review review = new Review();
        review.setComment(reviewRequestDTO.comment());
        review.setRating(reviewRequestDTO.rating());

        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, ReviewRequestDTO reviewRequestDTO) {
        Review review = reviewRepository.getReviewById(id);
        if(review == null){
            throw new IDNotFoundException("ID not found for id: " + id);
        }
        review.setComment(reviewRequestDTO.comment());
        review.setRating(reviewRequestDTO.rating());

        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
