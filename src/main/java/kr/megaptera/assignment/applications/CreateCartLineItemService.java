package kr.megaptera.assignment.applications;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.CartLineItemCreateDto;
import kr.megaptera.assignment.models.*;
import kr.megaptera.assignment.repository.CartRepository;
import kr.megaptera.assignment.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateCartLineItemService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CreateCartLineItemService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void create(CartLineItemCreateDto dto) {
        if (cartRepository.findById(CartId.DEFAULT).isEmpty()) {
            cartRepository.save(Cart.getCart());
        }
        Optional<Cart> cartOptional = cartRepository.findById(CartId.DEFAULT);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            cart.addLineItem(lineItem(dto));
            cartRepository.save(cart);
        }
    }

    private LineItem lineItem(CartLineItemCreateDto dto) {
        Optional<Product> productOptional = productRepository.findById(ProductId.of(dto.getProductId()));
        if (productOptional.isPresent()) {
            return LineItem.create(
                    productOptional.get(),
                    dto.getQuantity()
            );
        }
        throw new IllegalArgumentException();
    }
}
