package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CreateCartLineItemsInput;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import kr.megaptera.assignment.models.CartLineItem;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.CartLineItemRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateCartLineItemsService {
    private CartLineItemRepository cartLineItemRepository;
    private ProductRepository productRepository;

    public CreateCartLineItemsService(CartLineItemRepository cartLineItemRepository, ProductRepository productRepository) {
        this.cartLineItemRepository = cartLineItemRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public void createCartLineItems(CreateCartLineItemsInput createCartLineItemsInput) {
        Product product = productRepository.findById(Long.valueOf(createCartLineItemsInput.getProductId())).get();
        if (product == null) {
            throw new ProductNotFound();
        }
        cartLineItemRepository.save(new CartLineItem(createCartLineItemsInput, product));
    }
}
