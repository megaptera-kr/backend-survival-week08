package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.dtos.CreateCartDto;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.models.ProductName;
import kr.megaptera.assignment.models.ProductPrice;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CartServiceTest {

    private CartService cartService;
    private CartRepository cartRepository;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        cartRepository = mock(CartRepository.class);
        productRepository = mock(ProductRepository.class);
        cartService = new CartService(cartRepository, productRepository);
    }

    @Test
    @DisplayName("카트서비스 list")
    void list() {
        ProductId productId = new ProductId("100");
        ProductName productName = new ProductName("test");
        Long quantity = 1L;
        ProductPrice productPrice = new ProductPrice(10L);
        given(cartRepository.findAll()).willReturn(List.of(
                new Cart(productId, productName, quantity, productPrice),
                new Cart(productId, productName, 2L, productPrice),
                new Cart(productId, productName, 4L, productPrice)
        ));

        List<CartDto> dtoList = cartService.getCartLists();

        assertThat(dtoList).hasSize(3);
    }

    @Test
    @DisplayName("카트서비스 create")
    void create() {
        ProductId productId = new ProductId("100");
        ProductName productName = new ProductName("test");
        ProductPrice productPrice = new ProductPrice(10L);

        CreateCartDto createCartDto = new CreateCartDto("100", 10L);
        given(productRepository.findById(productId)).willReturn(
                Optional.of(new Product(productId, productName, productPrice))
        );

        Optional<Product> opProduct = productRepository.findById(productId);
        Cart cart = new Cart(opProduct.get().id(), opProduct.get().productName(), createCartDto.getQuantity(), opProduct.get().productPrice());

        cartRepository.save(cart);

        verify(cartRepository).save(any(Cart.class));
    }

    @Test
    @DisplayName("카트서비스 update")
    void update() {
        String productId = "100";
        CartDto cartDto = new CartDto(2L);

        given(cartRepository.findById(ProductId.of(productId))).willReturn(
                Optional.of(new Cart(ProductId.of("100"), ProductName.of("test"), 1L, ProductPrice.of(10L)))
        );

        Optional<Cart> cart = cartRepository.findById(ProductId.of(productId));
        cart.get().updateQuantity(cartDto.getQuantity());

        assertThat(cart.get().quantity() == 2L);
        assertThat(cart.get().id().toString()).isEqualTo(productId);
    }

}