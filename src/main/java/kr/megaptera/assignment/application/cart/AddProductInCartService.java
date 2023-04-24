package kr.megaptera.assignment.application.cart;

import kr.megaptera.assignment.DTOs.*;
import kr.megaptera.assignment.Models.cart.*;
import kr.megaptera.assignment.Models.product.*;
import kr.megaptera.assignment.exceptions.*;
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

    public void addProduct(String userId, CartAddDTO cartAddDTO) {
        Cart cart = cartRepository.findById(userId).get();
        Product product = productRepository.findById(ProductId.of(cartAddDTO.getProductId())).get();
        
        if (product == null) {
            throw new ProductNotFound("존재하지 않는 상품입니다.");
        }

        cart.addProduct(product, cartAddDTO.getQuantity());
    }
}
