package kr.megaptera.assignment.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {
    @Test
    public void productCreationTest() {
        Product product = Product.create(
                ProductName.of("the product"),
                Price.of(123L)
        );
        assertThat(product.getProductId()).isNotNull();
    }
}