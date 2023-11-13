package kr.megaptera.assignment.application.cart;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.models.LineItemId;
import kr.megaptera.assignment.repositories.CartRepository;

@Service
@Transactional
public class ChangeCartItemQuantityService {
    private final CartRepository cartRepository;

    public ChangeCartItemQuantityService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void changeQuantity(LineItemId lineItemId, int quantity) {
        Cart cart = cartRepository.findById(CartId.DEFAULT).get();

        cart.changeLineItemQuantity(lineItemId, quantity);
    }
}
