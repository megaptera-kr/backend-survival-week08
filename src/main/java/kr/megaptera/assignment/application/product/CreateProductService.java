package kr.megaptera.assignment.application.product;

import kr.megaptera.assignment.DTOs.product.*;
import kr.megaptera.assignment.Models.*;
import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

@Service
public class CreateProductService {

    private ProductRepository productRepository;


    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO create(ProductCreateDTO productCreateDTO) {
        Product product = new Product(
                ProductType.of(productCreateDTO.getType()),
                productCreateDTO.getName(),
                productCreateDTO.getPrice(),
                MultilineText.of(productCreateDTO.getContent()));

        productRepository.save(product);
        
        return new ProductDTO(product);
    }
}
