package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService {
    private final ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getProductDtos() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDto::new).toList();
    }
}
