package kr.megaptera.assignment.application.cart;

import kr.megaptera.assignment.DTOs.product.*;
import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class GetProductsInCartService {

    private ProductRepository productRepository;

    public GetProductsInCartService() {
    }

    public GetProductsInCartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<ProductDTO> getItemInCart(String userId) {
        List<Product> products = productRepository.findAllByUserId(userId);

        return products.stream().map(ProductDTO::new).toList();
    }
}
