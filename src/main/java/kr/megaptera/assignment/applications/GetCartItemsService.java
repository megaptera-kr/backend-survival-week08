package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CartItemDto;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.repositories.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCartItemsService {
    private final CartItemRepository cartItemRepository;

    public GetCartItemsService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItemDto> getCartItemDtos() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        System.out.println("cartItems : " + cartItems);
        return cartItems.stream().map(CartItemDto::new).toList();
    }
}
