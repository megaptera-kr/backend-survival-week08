package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.models.CartLineItem;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.CartLineItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetCartLineItemsServiceTest {

    private GetCartLineItemsService getCartLineItemsService;
    private CartLineItemRepository cartLineItemRepository;

    @BeforeEach
    void setUp() {
        cartLineItemRepository = mock(CartLineItemRepository.class);
        getCartLineItemsService = new GetCartLineItemsService(cartLineItemRepository);
    }

    @Test
    @DisplayName("장바구니 조회")
    void getLineItems() {
        given(cartLineItemRepository.findAll())
                .willReturn(List.of(new CartLineItem(new Product("productName", 1000L), 5L)));
        List<CartLineItem> lineItems = getCartLineItemsService.getLineItems();
        Assertions.assertThat(lineItems.size()).isEqualTo(1);
        Assertions.assertThat(lineItems.get(0).product()).isNotNull();
        Assertions.assertThat(lineItems.get(0).product().name()).isEqualTo("productName");

    }
}