package kr.megaptera.assignment.applications;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.UpdateCartItemDto;
import kr.megaptera.assignment.exceptions.CartItemNotFound;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.CartItemId;
import kr.megaptera.assignment.repositories.CartItemRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateCartService {
    private final CartItemRepository cartItemRepository;

    public UpdateCartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    public void updateCartItem(String cartItemId, UpdateCartItemDto updateCartItemDto) {
        CartItem cartItem = cartItemRepository.findById(CartItemId.of(cartItemId))
            .orElseThrow(CartItemNotFound::new);

        cartItem.updateCartItem(updateCartItemDto.getQuantity());

        if (cartItem.qantity() == 0) {
            cartItemRepository.delete(cartItem);
        }
    }
}
