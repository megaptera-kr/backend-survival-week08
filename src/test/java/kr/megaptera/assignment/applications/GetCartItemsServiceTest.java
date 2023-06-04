package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CartItemDto;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GetCartItemsServiceTest {
    private CartItemRepository cartItemRepository;
    private GetCartItemsService getCartItemsService;

    @BeforeEach
    void setUp() {
        cartItemRepository = mock(CartItemRepository.class);
        getCartItemsService = new GetCartItemsService(cartItemRepository);
    }

    @Test
    @DisplayName("장바구니 조회")
    void list() {
        Product product1 = new Product(ProductId.of("A-1"), "A", 1000L);
        Product product2 = new Product(ProductId.of("B-1"), "B", 3000L);

        given(cartItemRepository.findAll()).willReturn(
                List.of(
                        new CartItem(product1, 3),
                        new CartItem(product2, 2)
                )
        );

        List<CartItemDto> cartItemDtos = getCartItemsService.getCartItemDtos();

        assertThat(cartItemDtos).hasSize(2);
    }
}
