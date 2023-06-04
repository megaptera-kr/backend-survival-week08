package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.dtos.response.RpGetProductsDto;
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


    public RpGetProductsDto getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtoList = products.stream().map(ProductDto::new).toList();
        return new RpGetProductsDto(productDtoList);
    }
}
