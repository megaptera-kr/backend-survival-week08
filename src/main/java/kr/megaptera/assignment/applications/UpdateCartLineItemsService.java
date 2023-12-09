package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.UpdateCartLineItemsInput;
import kr.megaptera.assignment.exceptions.CartLineItemNotFound;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import kr.megaptera.assignment.models.CartLineItem;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.CartLineItemRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateCartLineItemsService {
    private CartLineItemRepository cartLineItemRepository;
    private ProductRepository productRepository;

    public UpdateCartLineItemsService(CartLineItemRepository cartLineItemRepository, ProductRepository productRepository) {
        this.cartLineItemRepository = cartLineItemRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public void updateQuantity(String id, UpdateCartLineItemsInput updateCartLineItemsInput) {

        Product product = productRepository.findById(Long.valueOf(id)).get();
        if (product == null) {
            throw new ProductNotFound();
        }
        CartLineItem cartLineItem = product.cartLineItem();
        if (cartLineItem == null) {
            throw new CartLineItemNotFound();
        }
        product.updateCartLineItem(updateCartLineItemsInput);
    }
}
