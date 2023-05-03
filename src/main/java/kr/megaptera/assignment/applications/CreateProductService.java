package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.*;
import kr.megaptera.assignment.models.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

@Service
public class CreateProductService {
    private ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductCreateDto productCreateDto) {
        Product product = new Product(ProductId.generate(),productCreateDto.getName(),productCreateDto.getPrice());
        productRepository.save(product);
    }
}
