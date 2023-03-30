package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> new ProductDto(product)).toList();
    }

    public ProductDto getProduct(String id) {
        Product product = productRepository.findById(ProductId.of(id)).orElseThrow();
        return new ProductDto(product);
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = new Product(productDto.getName(), productDto.getDescription(),
                productDto.getBrand(), productDto.getCategory(), productDto.getSubCategory());

        product = productRepository.save(product);
        return new ProductDto(product);
    }

    public ProductDto updateProduct(String id, ProductDto productDto) {
        Product product = productRepository.findById(ProductId.of(id)).orElseThrow();
        product.update(productDto.getName(), productDto.getDescription());

        product = productRepository.save(product);
        return new ProductDto(product);
    }

    public ProductDto removeProduct(String id) {
        Product product = productRepository.findById(ProductId.of(id)).orElseThrow();
        productRepository.delete(product);
        return new ProductDto(product);
    }

}
