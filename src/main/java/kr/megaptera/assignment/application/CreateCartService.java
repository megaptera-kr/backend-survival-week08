package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CartPostDto;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import kr.megaptera.assignment.models.cart.Cart;
import kr.megaptera.assignment.models.cart.CartId;
import kr.megaptera.assignment.models.products.Product;
import kr.megaptera.assignment.models.products.ProductId;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateCartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CreateCartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }


    public void createCartLineItem(CartPostDto cartPostDto) {
        Cart cart = getCart();

        Optional<Product> check = productRepository.findById(ProductId.of(cartPostDto.getProductId()));
        if (check.isEmpty()) {
            throw new ProductNotFound();
        }
        Product product = check.get();

        cart.addItem(product, cartPostDto.getQuantity());

        cartRepository.save(cart);
    }

    private Cart getCart() {
        Optional<Cart> check = cartRepository.findById(new CartId());
        if (check.isEmpty()) {
            Cart cart = new Cart(new CartId());
            cartRepository.save(cart);
            check = Optional.of(cart);
        }
        return check.get();
    }
}
