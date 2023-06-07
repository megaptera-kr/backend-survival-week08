package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CartUpdateDto;
import kr.megaptera.assignment.models.cart.Cart;
import kr.megaptera.assignment.models.cart.CartId;
import kr.megaptera.assignment.models.cart.Item;
import kr.megaptera.assignment.models.products.Price;
import kr.megaptera.assignment.models.products.Product;
import kr.megaptera.assignment.models.products.ProductName;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class UpdateCartServiceTest {

    private CartRepository cartRepository;

    private ProductRepository productRepository;

    private UpdateCartService updateCartService;

    private Cart cart;

    @BeforeEach
    void setUp() {
        cartRepository = mock(CartRepository.class);
        productRepository = mock(ProductRepository.class);
        cart = mock(Cart.class);
        updateCartService = new UpdateCartService(cartRepository, productRepository);
    }

    @Test
    @DisplayName("장바구니 상품 변경")
    void updateItem() {
        Product product = new Product(ProductName.of("랑데부"), Price.of(15000));

        given(cartRepository.findById(new CartId()))
                .willReturn(Optional.of(cart));

        given(cart.lineItems())
                .willReturn(List.of(
                        new Item(product, 2L)));

        given(productRepository.existsById(product.id()))
                .willReturn(true);

        CartUpdateDto cartUpdateDto1 = new CartUpdateDto(3L);

        updateCartService.updateCartLineItem(product.id().getId(), cartUpdateDto1);

        verify(cart).changeItemQuantity(any(String.class), any(Long.class));

        CartUpdateDto cartUpdateDto2 = new CartUpdateDto(0L);
        updateCartService.updateCartLineItem(product.id().getId(), cartUpdateDto2);

        verify(cart).removeItem(any(String.class));
        verify(cartRepository, times(2)).save(any(Cart.class));
    }
}