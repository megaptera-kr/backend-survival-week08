package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.ProductGetDto;
import kr.megaptera.assignment.dtos.ProductPostDto;
import kr.megaptera.assignment.models.products.Price;
import kr.megaptera.assignment.models.products.Product;
import kr.megaptera.assignment.models.products.ProductName;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductGetDto> getProducts() {
        return productRepository.findAll().stream().map(
                        p -> new ProductGetDto(
                                p.getId().getId(),
                                p.getName().getName(),
                                p.getPrice().getValue()))
                .collect(Collectors.toList());
    }

    public ProductGetDto createProduct(ProductPostDto productPostDto) {
        Product product = new Product(
                ProductName.of(productPostDto.getName()),
                Price.of(productPostDto.getPrice()));
        productRepository.save(product);
        return new ProductGetDto(
                product.getId().getId(),
                product.getName().getName(),
                product.getPrice().getValue()
        );
    }
}
