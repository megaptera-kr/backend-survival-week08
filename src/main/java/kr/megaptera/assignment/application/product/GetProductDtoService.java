package kr.megaptera.assignment.application.product;

import kr.megaptera.assignment.DTOs.product.*;
import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

@Service
public class GetProductDtoService {
    private ProductRepository productRepository;

    public GetProductDtoService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO getProductDTO(String id) {
        Product product = productRepository.findById(ProductId.of(id)).get();
        return new ProductDTO(product);
    }
}
