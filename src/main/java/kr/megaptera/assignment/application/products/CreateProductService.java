package kr.megaptera.assignment.application.products;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.products.CreateProductDto;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateProductService {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(CreateProductDto createProductDto) {
    }
}
