package kr.megaptera.assignment.application.cart;

import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AddProductToCartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public AddProductToCartService(CartRepository cartRepository,
                                   ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public Cart addProduct(ProductId productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow();

        Cart cart = cartRepository.findById(CartId.DEFAULT)
                .orElse(new Cart(CartId.DEFAULT));

        cart.addProduct(product, quantity);

        cartRepository.save(cart);

        return cart;
    }
}
