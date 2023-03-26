package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CreateProductRequest;
import kr.megaptera.assignment.dtos.ProductResponse;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateProductService {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponse createProduct(CreateProductRequest request) {

        Product saved = productRepository.save(Product.create(request));
        return new ProductResponse(saved);
    }
}
