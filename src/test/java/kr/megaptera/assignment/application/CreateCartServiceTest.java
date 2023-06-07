package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CartPostDto;
import kr.megaptera.assignment.models.cart.Cart;
import kr.megaptera.assignment.models.cart.CartId;
import kr.megaptera.assignment.models.products.Price;
import kr.megaptera.assignment.models.products.Product;
import kr.megaptera.assignment.models.products.ProductName;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateCartServiceTest {

    private CartRepository cartRepository;

    private ProductRepository productRepository;

    private CreateCartService createCartService;

    private Cart cart;

    @BeforeEach
    void setUp() {
        cartRepository = mock(CartRepository.class);
        productRepository = mock(ProductRepository.class);
        cart = mock(Cart.class);
        createCartService = new CreateCartService(cartRepository, productRepository);
    }

    @Test
    @DisplayName("장바구니 상품 등록")
    void addItem() {
        Product product = new Product(ProductName.of("랑데부"), Price.of(15000));

        given(cartRepository.findById(new CartId()))
                .willReturn(Optional.of(cart));

        given(productRepository.findById(product.id()))
                .willReturn(Optional.of(product));

        CartPostDto dto = new CartPostDto(product.id().getId(), 2L);

        createCartService.createCartLineItem(dto);

        verify(cartRepository).save(any(Cart.class));

    }

}