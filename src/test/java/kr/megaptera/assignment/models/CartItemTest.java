package kr.megaptera.assignment.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CartItemTest {

    @Test
    void creation() {
        CartItemId cartItemId = new CartItemId(Long.valueOf(1));
        CartItem cartItem = new CartItem(
                cartItemId,
                new Product("가가가", Long.valueOf(1000)),
                2
        );

        assertThat(cartItem.id().toLong()).isEqualTo(Long.valueOf(1));
        assertThat(cartItem.product().name()).isEqualTo("가가가");
        assertThat(cartItem.product().price()).isEqualTo(1000);
        assertThat(cartItem.quantity()).isEqualTo(2);


        assertThat(cartItem.unitPrice()).isEqualTo(1000);
        assertThat(cartItem.totalPrice()).isEqualTo(2000);

    }
}
