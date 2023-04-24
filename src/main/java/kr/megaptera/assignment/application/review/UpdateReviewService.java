package kr.megaptera.assignment.application.review;

import kr.megaptera.assignment.DTOs.review.*;
import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.exceptions.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

@Service
public class UpdateReviewService {

    private ProductRepository productRepository;

    public UpdateReviewService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void update(String id, String productId, ReviewUpdateDTO reviewUpdateDTO) {
        Product product = productRepository.findById(ProductId.of(productId)).get();

        if (product == null) {
            throw new ProductNotFound("상품이 존재하지 않습니다.");
        }

        product.updateReview(id, reviewUpdateDTO);
    }
}
