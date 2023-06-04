package kr.megaptera.assignment.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {
    @Test
    void creation() {
        Product product = new Product(
                "가나다",
                Long.valueOf(1000)
        );

        assertThat(product.name()).isEqualTo("가나다");
        assertThat(product.price()).isEqualTo(1000);
    }
}
