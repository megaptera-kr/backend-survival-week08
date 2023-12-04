package kr.megaptera.assignment.product.service;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.product.domain.Money;
import kr.megaptera.assignment.product.domain.Product;
import kr.megaptera.assignment.product.domain.ProductRepository;
import kr.megaptera.assignment.product.dto.CreateProductRequest;
import kr.megaptera.assignment.product.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> listProduct() {
        List<Product> productEntities =  productRepository.findAll();
        return productEntities.stream()
                .map(Product::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void createProduct(CreateProductRequest request) {
        Money price = new Money(request.price());
        Product newProduct = Product.create(request.name(), price);
        productRepository.save(newProduct);
    }
}
