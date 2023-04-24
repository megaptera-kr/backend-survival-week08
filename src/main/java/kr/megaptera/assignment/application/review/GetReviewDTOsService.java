package kr.megaptera.assignment.application.review;

import kr.megaptera.assignment.DTOs.review.*;
import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.Models.review.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class GetReviewDTOsService {

    private ProductRepository productRepository;

    public GetReviewDTOsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ReviewDTO> getReviewDTOs(String productId) {
        Product product = productRepository.findById(ProductId.of(productId)).get();

        List<Review> list = product.list();

        return list.stream().map(ReviewDTO::new).toList();
    }
}
