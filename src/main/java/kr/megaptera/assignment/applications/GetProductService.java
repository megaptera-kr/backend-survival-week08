package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.dtos.ProductDtos;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductService {
    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductDtos getProductDtos() {
        List<Product> products = productRepository.findAll();
        return new ProductDtos(products.stream().map(ProductDto::new).toList());
    }
}
