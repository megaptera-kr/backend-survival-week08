package kr.megaptera.assignment.models;

import kr.megaptera.assignment.dtos.CartItemDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CartItemTest {

    @Test
    void creation() {
        CartItem cartItem = new CartItem(
                Long.valueOf(1),
          new Product("가가가", Long.valueOf(1000)),
          2
        );

        assertThat(cartItem.id()).isEqualTo(1);
        assertThat(cartItem.product().name()).isEqualTo("가가가");
        assertThat(cartItem.product().price()).isEqualTo(1000);
        assertThat(cartItem.quantity()).isEqualTo(2);


        assertThat(cartItem.unitPrice()).isEqualTo(1000);
        assertThat(cartItem.totalPrice()).isEqualTo(2000);

    }
}
