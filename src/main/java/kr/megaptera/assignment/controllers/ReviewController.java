package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.ReviewService;
import kr.megaptera.assignment.dtos.ItemDto;
import kr.megaptera.assignment.dtos.ReviewDto;
import kr.megaptera.assignment.models.Review;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/products/{productId}/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> getReviewsByProduct(@PathVariable String productId) {
        List<ReviewDto> reviewDtos = reviewService.getReviewsByProductId(productId);
        return reviewDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewDto createReview(@RequestAttribute String userId,
                                  @PathVariable String productId, @RequestBody String contents) {
        ReviewDto createdReviewDto = reviewService.createReview(userId, productId, contents);
        log.info("A Review of Product " + productId + " is created by User " + userId + ".");
        return createdReviewDto;
    }

    @PatchMapping("/{reviewId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ReviewDto updateReview(@RequestAttribute String userId, @PathVariable String productId,
                               @PathVariable String reviewId, @RequestBody String contents) {
        ReviewDto updatedReviewDto = reviewService.updateReview(reviewId, contents);
        log.info("A Review " + reviewId + " of Product " + productId + " is updated by User " + userId + ".");
        return updatedReviewDto;
    }

    @DeleteMapping("/{reviewId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ReviewDto deleteReview(@RequestAttribute String userId, @PathVariable Long productId,
                               @PathVariable String reviewId) {
        ReviewDto deletedReviewDto = reviewService.deleteReview(reviewId);
        log.info("A Review " + reviewId + " of Product " + productId + " is deleted by User " + userId + ".");
        return deletedReviewDto;
    }

}
