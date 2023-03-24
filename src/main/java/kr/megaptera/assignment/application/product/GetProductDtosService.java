package kr.megaptera.assignment.application.product;

import kr.megaptera.assignment.DTOs.product.*;
import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class GetProductDtosService {
    private ProductRepository productRepository;

    public GetProductDtosService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getProductDTOs() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(ProductDTO::new).toList();
    }
}
