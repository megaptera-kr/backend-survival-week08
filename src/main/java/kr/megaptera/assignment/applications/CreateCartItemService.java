package kr.megaptera.assignment.applications;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.CartItemCreateDto;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateCartItemService {
    //    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;


    public CreateCartItemService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public void createCartItem(CartItemCreateDto cartItemCreateDto) {
        Product product = productRepository.findById(ProductId.of(cartItemCreateDto.getProductId()))
                .orElseThrow(ProductNotFound::new);
        System.out.println("product : " + product);
        CartItem cartItem = new CartItem(
                product,
                cartItemCreateDto.getQuantity()
        );

        System.out.println("cartItem : " + cartItem);

        Cart cart = cartRepository.findById(CartId.DEFAULT).orElseThrow();

        cart.addItem(product, cartItemCreateDto.getQuantity());

        cartRepository.save(cart);
    }
}
