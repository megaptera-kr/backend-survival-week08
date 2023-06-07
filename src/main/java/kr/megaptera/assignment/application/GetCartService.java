package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CartListItemDto;
import kr.megaptera.assignment.dtos.ItemDto;
import kr.megaptera.assignment.models.cart.Cart;
import kr.megaptera.assignment.models.cart.CartId;
import kr.megaptera.assignment.repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetCartService {

    private final CartRepository cartRepository;

    public GetCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartListItemDto getCartLineItems() {
        Cart cart = getCart();

        return new CartListItemDto(
                cart.lineItems()
                        .stream()
                        .map(ItemDto::new)
                        .collect(Collectors.toList()));
    }

    Cart getCart() {
        Optional<Cart> check = cartRepository.findById(new CartId());
        if (check.isEmpty()) {
            Cart cart = new Cart(new CartId());
            cartRepository.save(cart);
            check = Optional.of(cart);
        }
        return check.get();
    }
}
