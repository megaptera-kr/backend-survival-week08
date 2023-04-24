package kr.megaptera.assignment.application.review;

import kr.megaptera.assignment.DTOs.review.*;
import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.Models.review.*;
import kr.megaptera.assignment.exceptions.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

@Service
public class CreateReviewService {

    private ProductRepository productRepository;

    public CreateReviewService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ReviewDTO create(String productId, ReviewCreateDTO reviewCreateDTO) {
        Product product = productRepository.findById(ProductId.of(productId)).get();

        if (product == null) {
            throw new ProductNotFound("존재하지 않는 상품입니다.");
        }

        Review review = product.addReview(productId, reviewCreateDTO);

        return new ReviewDTO(review);
    }
}
