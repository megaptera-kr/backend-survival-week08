package kr.megaptera.assignment.application.cart;

import kr.megaptera.assignment.DTOs.*;
import kr.megaptera.assignment.Models.cart.*;
import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

@Service
public class AddProductInCartService {

    private ProductRepository productRepository;

    private CartRepository cartRepository;

    public AddProductInCartService() {
    }

    public AddProductInCartService(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public void addProductInCart(String userId, CartDTO cartDTO) {
        Cart cart = cartRepository.findById(userId).get();
        Product product = productRepository.findById(ProductId.of(cartDTO.getProductId())).get();
        Product copy = product;
        copy.updateQuantity(cartDTO.getQuantity());
        cart.addProductInCart(copy);
    }
}
