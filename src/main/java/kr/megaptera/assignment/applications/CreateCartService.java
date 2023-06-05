package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CreateCartItemDto;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.CartItemId;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartItemRepository;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CreateCartService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CreateCartService(ProductRepository productRepository, CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public void createCartItem(CreateCartItemDto createCartItemDto) {
        Product product = productRepository.findById(ProductId.of(createCartItemDto.getProductId()))
            .orElseThrow(ProductNotFound::new);

        // 원래는 cart도 repository에서 사용자 고유의 cart를 찾아야한다.
        Cart cart = new Cart(CartId.generate(), new ArrayList<>());
        cartRepository.save(cart);

        CartItem cartItem = new CartItem(CartItemId.generate(), cart, product, createCartItemDto.getQuantity());

        cart.addCartItem(cartItem.product(), cartItem.qantity());

        cartItemRepository.save(cartItem);
    }
}
