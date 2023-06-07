package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.ProductGetDto;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetProductsService {

    private final ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductGetDto> getProducts() {
        return productRepository.findAll().stream().map(
                        p -> new ProductGetDto(
                                p.id().getId(),
                                p.name().getName(),
                                p.price().getValue()))
                .collect(Collectors.toList());
    }
}
