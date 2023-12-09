package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.models.CartLineItem;
import kr.megaptera.assignment.repositories.CartLineItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCartLineItemsService {
    private CartLineItemRepository cartLineItemRepository;

    public GetCartLineItemsService(CartLineItemRepository cartLineItemRepository) {
        this.cartLineItemRepository = cartLineItemRepository;
    }

    public List<CartLineItem> getLineItems() {
        return (List<CartLineItem>) cartLineItemRepository.findAll();
    }
}
