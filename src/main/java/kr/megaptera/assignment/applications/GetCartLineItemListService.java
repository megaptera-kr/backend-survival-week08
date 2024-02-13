package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CartLineItemDetailDto;
import kr.megaptera.assignment.dtos.CartLineItemDetailListDto;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.models.LineItem;
import kr.megaptera.assignment.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCartLineItemListService {
    private final CartRepository cartRepository;

    public GetCartLineItemListService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartLineItemDetailListDto list() {
        Optional<Cart> cartOptional = cartRepository.findById(CartId.DEFAULT);
        return cartOptional.map(this::cartLineItemDetailListDto)
                .orElseGet(CartLineItemDetailListDto::empty);
    }

    private CartLineItemDetailListDto cartLineItemDetailListDto(Cart cart) {
        return CartLineItemDetailListDto.of(
                cart.getLineItemList().stream().map(this::cartLineItemDetailDto).toList()
        );
    }

    private CartLineItemDetailDto cartLineItemDetailDto(LineItem lineItem) {
        return CartLineItemDetailDto.of(
                lineItem.getLineItemId().toString(),
                lineItem.getProductName().getValue(),
                lineItem.getQuantity(),
                lineItem.getTotalPrice().getValue(),
                lineItem.getUnitPrice().getValue()
        );
    }
}
