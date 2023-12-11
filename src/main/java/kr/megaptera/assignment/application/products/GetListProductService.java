package kr.megaptera.assignment.application.products;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.products.ProductDto;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GetListProductService {
    private final ProductRepository productRepository;

    public GetListProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getListProduct() {
        return this.productRepository.findAll().stream().map(ProductDto::of).toList();
    }
}
