package kr.megaptera.assignment.applications.carts;

import kr.megaptera.assignment.domains.carts.CartItem;
import kr.megaptera.assignment.infrastructures.CartRepository;
import kr.megaptera.assignment.presentations.dtos.carts.CartItemDto;
import kr.megaptera.assignment.presentations.dtos.carts.CartLineItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCartItemsService {
    @Autowired
    private CartRepository cartRepository;

    public CartLineItemDto getAll() {
        var carts = cartRepository.findAll();
        var dtos = carts.stream().map(row ->convertCartItemDto(row)).toList();
        return new CartLineItemDto(dtos);
    }

    private CartItemDto convertCartItemDto(CartItem cartItem) {

        var unitPrice = cartItem.getProduct().getPrice();
        var totalPrice = unitPrice * cartItem.getQuantity();

        return new CartItemDto(
                cartItem.getId().toString(),
                cartItem.getProduct().getName(),
                cartItem.getQuantity(),
                totalPrice,
                unitPrice);
    }
}
