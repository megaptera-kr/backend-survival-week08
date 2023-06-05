package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CartItemDto;
import kr.megaptera.assignment.dtos.CartItemDtos;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.repositories.CartItemRepository;
import kr.megaptera.assignment.repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCartService {
    private final CartItemRepository cartItemRepository;

    public GetCartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItemDtos getCartItemDtos() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        List<CartItemDto> cartItemDtos = cartItems.stream().map(CartItemDto::new).toList();
        return new CartItemDtos(cartItemDtos);
    }
}
