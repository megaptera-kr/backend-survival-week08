package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.request.RqPostProductDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String createProduct(RqPostProductDto dto) {

        Product product = Product.of(dto.getName(), dto.getPrice());

        productRepository.save(product);

        return "";
    }
}
