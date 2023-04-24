package kr.megaptera.assignment.application.review;

import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.exceptions.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

@Service
public class DeleteReviewService {

    private ProductRepository productRepository;

    public DeleteReviewService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void delete(String id, String productId) {
        Product product = productRepository.findById(ProductId.of(productId)).get();

        if (product == null) {
            throw new ProductNotFound("상품이 존재하지 않습니다.");
        }

        product.removeReview(id);
    }
}
