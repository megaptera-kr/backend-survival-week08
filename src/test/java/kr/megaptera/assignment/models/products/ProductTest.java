package kr.megaptera.assignment.models.products;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void creation() {
        Product product = new Product(ProductName.of("랑데부"), Price.of(15000));

        assertThat(product.id()).isNotNull();
        assertThat(product.name().getName()).contains("랑데부");
        assertThat(product.price().getValue()).isEqualTo(15000);
    }
}