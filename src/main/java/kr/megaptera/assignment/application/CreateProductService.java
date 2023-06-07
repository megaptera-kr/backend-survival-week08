package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.ProductCreateDto;
import kr.megaptera.assignment.dtos.ProductGetDto;
import kr.megaptera.assignment.models.products.Price;
import kr.megaptera.assignment.models.products.Product;
import kr.megaptera.assignment.models.products.ProductName;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductGetDto createProduct(ProductCreateDto productCreateDto) {
        Product product = new Product(
                ProductName.of(productCreateDto.getName()),
                Price.of(productCreateDto.getPrice()));
        productRepository.save(product);
        return new ProductGetDto(
                product.id().getId(),
                product.name().getName(),
                product.price().getValue()
        );
    }
}
