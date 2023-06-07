package kr.megaptera.assignment.models.cart;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuantityTest {

    @Test
    void creation() {
        Quantity quantity = new Quantity(22000);

        assertThat(quantity.getValue()).isEqualTo(22000);
    }

}