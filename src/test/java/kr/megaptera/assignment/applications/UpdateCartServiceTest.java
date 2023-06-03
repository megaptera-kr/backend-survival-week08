package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.UpdateCartItemDto;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.CartItemId;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.CartItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class UpdateCartServiceTest {
    private CartItemRepository cartItemRepository;

    private UpdateCartService updateCartService;

    @BeforeEach
    void setUp() {
        cartItemRepository = mock(CartItemRepository.class);

        updateCartService = new UpdateCartService(cartItemRepository);
    }

    @Test
    void updateCartItem() {
        CartItem cartItem = new CartItem(CartItemId.of("1"), new Cart(), new Product(), 1L);
        given(cartItemRepository.findById(any())).willReturn(Optional.of(cartItem));

        UpdateCartItemDto updateCartItemDto = new UpdateCartItemDto(2L);
        updateCartService.updateCartItem("1", updateCartItemDto);

        assertThat(cartItem.qantity()).isEqualTo(2);
    }
}
