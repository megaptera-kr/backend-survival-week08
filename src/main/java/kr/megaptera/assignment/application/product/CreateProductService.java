package kr.megaptera.assignment.application.product;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import kr.megaptera.assignment.models.Money;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;

@Service
@Transactional
public class CreateProductService {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(String name, Money price) {
        Product product = Product.create(name, price);

        productRepository.save(product);

        return product;
    }
}
