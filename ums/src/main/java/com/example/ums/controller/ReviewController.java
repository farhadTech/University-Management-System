package com.example.ums.controller;

import com.example.ums.dto.request.ReviewRequestDTO;
import com.example.ums.dto.response.ReviewResponseDTO;
import com.example.ums.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    ResponseEntity<List<ReviewResponseDTO>> getAllReviews() {
        return new ResponseEntity<> (reviewService.getAllReviews(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<ReviewResponseDTO> getReviewById(Long id) {
        ReviewResponseDTO review = reviewService.getReviewById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<String> createReview(@Valid @RequestBody ReviewRequestDTO reviewRequestDTO) {
        reviewService.createReview(reviewRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Review created");
    }

    @PutMapping("/{id}")
    ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody ReviewRequestDTO reviewRequestDTO) {
        reviewService.updateReview(id, reviewRequestDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Review updated with id: " + id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteReview(Long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}










