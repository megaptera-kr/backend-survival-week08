package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CartItemDto;
import kr.megaptera.assignment.dtos.CartItemDtos;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.CartItemId;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartItemRepository;
import kr.megaptera.assignment.repositories.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetCartServiceTest {
    private CartItemRepository cartItemRepository;
    private GetCartService getCartService;

    @BeforeEach
    void setUp() {
        cartItemRepository = mock(CartItemRepository.class);

        getCartService = new GetCartService(cartItemRepository);
    }

    @Test
    void getCartItemDtos() {
        Cart cart = new Cart(CartId.of("1"), new ArrayList<>());
        Product product = new Product(ProductId.of("1"), "상품명", 3000L);
        CartItem cartItem = new CartItem(CartItemId.of("1"), cart, product, 1L);

        given(cartItemRepository.findAll()).willReturn(List.of(cartItem));

        CartItemDtos cartItemDtos = getCartService.getCartItemDtos();

        assertThat(cartItemDtos.getLineItems()).hasSize(1);
        assertThat(cartItemDtos.getLineItems().get(0).getProductName()).isEqualTo("상품명");
        assertThat(cartItemDtos.getLineItems().get(0).getQuantity()).isEqualTo(1L);
        assertThat(cartItemDtos.getLineItems().get(0).getTotalPrice()).isEqualTo(3000L);
        assertThat(cartItemDtos.getLineItems().get(0).getUnitPrice()).isEqualTo(3000L);
    }
}
