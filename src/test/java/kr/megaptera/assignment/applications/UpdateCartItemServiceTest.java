package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CartItemUpdateDto;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.CartItemId;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class UpdateCartItemServiceTest {
    private CartItemRepository cartItemRepository;

    private UpdateCartItemService updateCartItemServiceTest;

    @BeforeEach
    void setUp() {
        cartItemRepository = mock(CartItemRepository.class);

        updateCartItemServiceTest = new UpdateCartItemService(cartItemRepository);
    }

    @Test
    @DisplayName("게시물 수정")
    void update() {
        CartItemId cartItemId = new CartItemId(1L);
        Product product = new Product(ProductId.of("A-1"), "A", 1000L);

        CartItem cartItem =
                new CartItem(cartItemId, product, 3);

        given(cartItemRepository.findById(cartItemId)).willReturn(Optional.of(cartItem));

        CartItemUpdateDto cartItemUpdateDto =
                new CartItemUpdateDto(5);

        updateCartItemServiceTest.updateCartItemProdudctQuantity(cartItemId.toString(), cartItemUpdateDto);
        
        assertThat(cartItem.quantity()).isEqualTo(5);
    }
}
