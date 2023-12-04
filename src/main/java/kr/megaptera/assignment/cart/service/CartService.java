package kr.megaptera.assignment.cart.service;
import jakarta.transaction.Transactional;
import jdk.swing.interop.SwingInterOpUtils;
import kr.megaptera.assignment.cart.domain.Cart;
import kr.megaptera.assignment.cart.domain.CartId;
import kr.megaptera.assignment.cart.domain.LineItem;
import kr.megaptera.assignment.cart.domain.LineItemId;
import kr.megaptera.assignment.cart.dto.CartResponse;
import kr.megaptera.assignment.cart.service.port.CartItemRepository;
import kr.megaptera.assignment.cart.dto.UpdateQuantityRequest;
import kr.megaptera.assignment.product.domain.Product;
import kr.megaptera.assignment.product.domain.ProductId;
import kr.megaptera.assignment.product.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Cart addProduct(ProductId productId, Long quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow();

        Cart cart = cartItemRepository.findById(CartId.DEFAULT)
                .orElse(new Cart(CartId.DEFAULT));

        cart.addProduct(product, quantity);

        cartItemRepository.save(cart);

        return cart;
    }

    @Transactional
    public void changeQuantity(LineItemId lineItemId, Long quantity) {
        Cart cart = cartItemRepository.findById(CartId.DEFAULT).get();

        cart.changeLineItemQuantity(lineItemId, quantity);
    }

    public CartResponse listItems() {
        Optional<Cart> cart = cartItemRepository.findByIdWithLineItems(CartId.DEFAULT);
        if (cart.isPresent()) {
            return cart.get().toResponse();
        }
        return new CartResponse(Collections.emptyList());
    }
}
