package kr.megaptera.assignment.application;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.CartUpdateDto;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import kr.megaptera.assignment.models.cart.Cart;
import kr.megaptera.assignment.models.cart.CartId;
import kr.megaptera.assignment.models.products.ProductId;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public UpdateCartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public void updateCartLineItem(String id, CartUpdateDto cartUpdateDto) {
        Cart cart = getCart();

        if (productRepository.existsById(ProductId.of(id))) {
            if (cartUpdateDto.getQuantity() == 0) {
                cart.removeItem(id);
            } else {
                cart.changeItemQuantity(id, cartUpdateDto.getQuantity());
            }
        } else {
            throw new ProductNotFound();
        }
        cartRepository.save(cart);
    }

    private Cart getCart() {
        Optional<Cart> check = cartRepository.findById(new CartId());
        if (check.isEmpty()) {
            Cart cart = new Cart(new CartId());
            cartRepository.save(cart);
            check = Optional.of(cart);
        }
        return check.get();
    }
}
