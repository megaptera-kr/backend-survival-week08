package kr.megaptera.assignment.application.product;

import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

@Service
public class DeleteProductService {

    private ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void delete(String id) {
        Product product = productRepository.findById(ProductId.of(id)).get();

        productRepository.delete(product);
    }
}
