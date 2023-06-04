package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.request.RqUpdateCartItemDto;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.repositories.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateCartItemService {

    private final CartRepository cartRepository;

    public UpdateCartItemService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public String updateCartItem(RqUpdateCartItemDto dto, String cartId) {

        Cart cart = cartRepository.findById(CartId.of(cartId))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        cart.updateQuantity(dto.getQuantity());

        cartRepository.save(cart);
        return "";
    }
}
