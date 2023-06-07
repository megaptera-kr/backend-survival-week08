package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CartListItemDto;
import kr.megaptera.assignment.models.cart.Cart;
import kr.megaptera.assignment.models.cart.CartId;
import kr.megaptera.assignment.models.cart.Item;
import kr.megaptera.assignment.models.products.Price;
import kr.megaptera.assignment.models.products.Product;
import kr.megaptera.assignment.models.products.ProductName;
import kr.megaptera.assignment.repositories.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetCartServiceTest {

    private CartRepository cartRepository;

    private GetCartService getCartService;

    private Cart cart;

    @BeforeEach
    void setUp() {
        cartRepository = mock(CartRepository.class);
        cart = mock(Cart.class);
        getCartService = new GetCartService(cartRepository);
    }

    @Test
    @DisplayName("장바구니 조회")
    void list() {
        Product product = new Product(ProductName.of("랑데부"), Price.of(15000));
        Product newProduct = new Product(ProductName.of("데자부"), Price.of(13000));

        given(cartRepository.findById(new CartId()))
                .willReturn(Optional.of(cart));

        given(cart.lineItems())
                .willReturn(List.of(
                        new Item(product, 2L),
                        new Item(newProduct, 3L)));

        CartListItemDto cartDto = getCartService.getCartLineItems();

        assertThat(cartDto.getLineItems().size()).isEqualTo(2);
        assertThat(cartDto.getLineItems().get(0).getProductName()).contains("랑데부");
        assertThat(cartDto.getLineItems().get(1).getProductName()).contains("데자부");
        assertThat(cartDto.getLineItems().get(1).getQuantity()).isEqualTo(3);
    }

}