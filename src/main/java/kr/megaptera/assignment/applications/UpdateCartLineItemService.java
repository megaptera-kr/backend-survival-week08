package kr.megaptera.assignment.controllers;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.CartLineItemUpdateDto;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.models.LineItem;
import kr.megaptera.assignment.models.LineItemId;
import kr.megaptera.assignment.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCartLineItemService {
    private final CartRepository cartRepository;

    public UpdateCartLineItemService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void update(String id, CartLineItemUpdateDto dto) {
        LineItemId lineItemId = LineItemId.of(id);
        if (cartRepository.findById(CartId.DEFAULT).isEmpty()) {
            cartRepository.save(Cart.getCart());
        }
        Optional<Cart> cartOptional = cartRepository.findById(CartId.DEFAULT);
        LineItem lineItem = cartOptional.get().getLineItem(lineItemId);
        lineItem.addQuantity(dto.getQuantity());
        cartRepository.save(cartOptional.get());
    }
}
