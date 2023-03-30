package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.ReviewDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.models.Review;
import kr.megaptera.assignment.models.ReviewId;
import kr.megaptera.assignment.repositories.ProductRepository;
import kr.megaptera.assignment.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final ProductRepository productRepository;

    public List<ReviewDto> getReviewsByProductId(String productId) {
        Product product = productRepository.findById(ProductId.of(productId)).orElseThrow();
        List<Review> reviews = reviewRepository.findByProduct(product);
        return reviews.stream().map(review -> new ReviewDto(review)).toList();
    }

    public ReviewDto createReview(String userId, String productId, String contents) {
        Product product = productRepository.findById(ProductId.of(productId)).orElseThrow();
        Review review = new Review(contents, userId, product);
        review = reviewRepository.save(review);
        return new ReviewDto(review);
    }

    public ReviewDto updateReview(String reviewId, String contents) {
        Review review = reviewRepository.findById(ReviewId.of(reviewId)).orElseThrow();
        review.update(contents);
        review = reviewRepository.save(review);
        return new ReviewDto(review);
    }

    public ReviewDto deleteReview(String reviewId) {
        Review review = reviewRepository.findById(ReviewId.of(reviewId)).orElseThrow();
        reviewRepository.delete(review);
        return new ReviewDto(review);
    }

}
