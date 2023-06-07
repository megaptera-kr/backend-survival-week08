package kr.megaptera.assignment.models.cart;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CartIdTest {

    @Test
    void creation() {
        CartId cartId1 = new CartId();
        CartId cartId2 = new CartId();
        CartId cartId3 = new CartId("3");

        assertThat(cartId1.getId()).isNotNull();
        assertThat(cartId2.getId()).isNotNull();
        assertThat(cartId1.getId()).isEqualTo(cartId2.getId());
        assertThat(cartId2.getId()).isEqualTo(CartId.DEFALUT);
        assertThat(cartId3.getId()).contains("3");
    }

}