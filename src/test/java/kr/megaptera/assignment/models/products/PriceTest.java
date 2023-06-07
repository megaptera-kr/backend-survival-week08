package kr.megaptera.assignment.models.prices;

import kr.megaptera.assignment.models.products.Price;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PriceTest {

    @Test
    void creation() {
        Price price = new Price(22000);

        assertThat(price.getValue()).isEqualTo(22000);
    }
}