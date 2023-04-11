package kr.megaptera.assignment.models;

import kr.megaptera.assignment.Fixtures;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    void creation() {
        Product product = Fixtures.product();
        ProductId productId = product.getId();

        Item item = new Item(product, "blue", "M", 100, 20_000, 15_000, 2);

        assertThat(item.getProduct().getId()).isEqualTo(productId);
        assertThat(item.getId()).isNotNull();
        assertThat(item.getColor()).isEqualTo("blue");
        assertThat(item.getSize()).isEqualTo("M");
        assertThat(item.getStock()).isEqualTo(100);
        assertThat(item.getOriginalPrice()).isEqualTo(20_000);
        assertThat(item.getOnSalePrice()).isEqualTo(15_000);
        assertThat(item.getShippingDays()).isEqualTo(2);
    }

    @Test
    void update() {
        Product product = Fixtures.product();
        ProductId productId = product.getId();

        Item item = new Item(product, "blue", "M", 100, 20_000, 15_000, 2);
        item.update(200, 20_000, 12_000, 3);

        assertThat(item.getStock()).isEqualTo(200);
        assertThat(item.getOriginalPrice()).isEqualTo(20_000);
        assertThat(item.getOnSalePrice()).isEqualTo(12_000);
        assertThat(item.getShippingDays()).isEqualTo(3);
    }

}
