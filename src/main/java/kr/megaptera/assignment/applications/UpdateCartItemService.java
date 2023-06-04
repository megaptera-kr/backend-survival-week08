package kr.megaptera.assignment.applications;


import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.CartItemUpdateDto;
import kr.megaptera.assignment.exceptions.CartItemNotFound;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.CartItemId;
import kr.megaptera.assignment.repositories.CartItemRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UpdateCartItemService {

    private final CartItemRepository cartItemRepository;

    public UpdateCartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void updateCartItemProdudctQuantity(String id, CartItemUpdateDto cartItemUpdateDto) {
        System.out.println("Update cartItem id: " + id);
        CartItem cartItem = cartItemRepository.findById(CartItemId.of(id))
                .orElseThrow(CartItemNotFound::new);
        System.out.println("Update cartItem : " + cartItem);
        cartItem.updateQuantity(cartItemUpdateDto.getQuantity());
    }
}
