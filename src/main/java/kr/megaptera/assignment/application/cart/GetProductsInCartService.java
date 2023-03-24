package kr.megaptera.assignment.application.cart;

import kr.megaptera.assignment.DTOs.product.*;
import kr.megaptera.assignment.Models.cart.*;
import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class GetProductsInCartService {

    private ProductRepository productRepository;
    private CartRepository cartRepository;

    public GetProductsInCartService() {
    }

    public GetProductsInCartService(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }


    public List<ProductDTO> getItemInCart(String userId) {
        Cart cart = cartRepository.findById(userId).get();
        List<Product> products = cart.getItems();
        return products.stream().map(ProductDTO::new).toList();
    }
}
