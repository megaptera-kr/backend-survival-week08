package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.UpdateCartLineItemsInputDto;
import kr.megaptera.assignment.exceptions.CartLineItemNotFound;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import kr.megaptera.assignment.models.CartLineItem;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateCartLineItemsService {
    private ProductRepository productRepository;

    public UpdateCartLineItemsService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Transactional
    public void updateQuantity(String id, UpdateCartLineItemsInputDto updateCartLineItemsInputDto) {

        Product product = productRepository.findById(Long.valueOf(id)).get();
        System.out.println(product);
        if (product == null) {
            throw new ProductNotFound();
        }
        CartLineItem cartLineItem = product.cartLineItem();
        if (cartLineItem == null) {
            throw new CartLineItemNotFound();
        }
        product.updateCartLineItemQuantity(updateCartLineItemsInputDto.getQuantity());
    }
}
