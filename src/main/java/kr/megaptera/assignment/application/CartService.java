package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.models.*;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    private final ItemRepository itemRepository;

    public List<CartDto> getCarts(String accountId) {
        List<Cart> carts = cartRepository.findByAccountId(accountId);
        return carts.stream().map(cart -> new CartDto(cart)).toList();
    }

    public CartDto addItemCoCart(String accountId, String itemId, Integer count) {
        Item item = itemRepository.findById(ItemId.of(itemId)).orElseThrow();
        Cart cart = new Cart(accountId, item, count);
        cart = cartRepository.save(cart);
        return new CartDto(cart);
    }

    public CartDto updateItemCoCart(String accountId, String cartId, Integer count) {
        Cart cart = cartRepository.findById(CartId.of(cartId)).orElseThrow();
        cart.update(count);
        cart = cartRepository.save(cart);
        return new CartDto(cart);
    }

    public CartDto removeCart(String accountId, String itemId) {
        Item item = itemRepository.findById(ItemId.of(itemId)).orElseThrow();
        Cart cart = cartRepository.findByItem(item);
        cartRepository.delete(cart);
        return new CartDto(cart);
    }
}
