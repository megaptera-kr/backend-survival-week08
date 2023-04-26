package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.*;
import kr.megaptera.assignment.models.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class GetProductsService {

    private ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getProductDtos() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDto::new).toList();
    }
}
