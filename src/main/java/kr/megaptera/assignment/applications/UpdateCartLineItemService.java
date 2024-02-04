package kr.megaptera.assignment.applications;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.CartLineItemUpdateDto;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
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
        cartOptional.get().setLineItemQuantity(lineItemId, dto.getQuantity());
        cartRepository.save(cartOptional.get());
    }
}
