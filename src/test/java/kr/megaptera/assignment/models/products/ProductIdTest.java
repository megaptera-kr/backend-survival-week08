package kr.megaptera.assignment.models.products;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductIdTest {

    @Test
    void creation() {
        ProductId productId1 = new ProductId();
        ProductId productId2 = new ProductId();
        ProductId productId3 = new ProductId("3");

        assertThat(productId1.getId()).isNotNull();
        assertThat(productId2.getId()).isNotNull();
        assertThat(productId1.getId()).isNotEqualTo(productId2.getId());
        assertThat(productId2.getId()).isGreaterThan(productId1.getId());
        assertThat(productId3.getId()).contains("3");
    }

}