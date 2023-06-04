package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.ProductCreateDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductCreateDto productCreateDto) {
        Product post = new Product(
                productCreateDto.getName(),
                productCreateDto.getPrice()
        );

        productRepository.save(post);
    }
}
