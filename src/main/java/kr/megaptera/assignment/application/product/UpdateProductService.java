package kr.megaptera.assignment.application.product;

import kr.megaptera.assignment.DTOs.product.*;
import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

@Service
public class UpdateProductService {

    private ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void update(String id, ProductUpdateDTO productUpdateDTO) {
        Product product = productRepository.findById(ProductId.of(id)).get();

        product.update(productUpdateDTO);
    }
}
