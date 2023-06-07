package kr.megaptera.assignment.models.cart;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemIdTest {

    @Test
    void creation() {
        ItemId itemId1 = new ItemId();
        ItemId itemId2 = new ItemId();
        ItemId itemId3 = new ItemId("3");

        assertThat(itemId1.getId()).isNotNull();
        assertThat(itemId2.getId()).isNotNull();
        assertThat(itemId1.getId()).isNotEqualTo(itemId2.getId());
        assertThat(itemId2.getId()).isGreaterThan(itemId1.getId());
        assertThat(itemId3.getId()).contains("3");
    }

}