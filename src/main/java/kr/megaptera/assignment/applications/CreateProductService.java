package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CreateProductDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(CreateProductDto createProductDto) {
        Product product = new Product(
            createProductDto.getName(),
            createProductDto.getPrice()
        );

        productRepository.save(product);
    }
}
