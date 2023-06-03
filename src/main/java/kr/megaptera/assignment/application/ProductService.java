package kr.megaptera.assignment.application;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductName;
import kr.megaptera.assignment.models.ProductPrice;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {


    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getList() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> new ProductDto(product)).toList();
    }

    public void create(ProductDto productDto) {
        Product product = new Product(ProductName.of(productDto.getName()), ProductPrice.of(productDto.getPrice()));
        productRepository.save(product);
    }
}
