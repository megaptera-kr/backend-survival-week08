package kr.megaptera.assignment.application.cart;

import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

@Service
public class RemoveProductIncartService {

    private ProductRepository productRepository;

    private CartRepository cartRepository;

    public RemoveProductIncartService() {
    }

    public RemoveProductIncartService(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

}
