package kr.megaptera.assignment.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void creation() {
        Product product = new Product("Test Product", "Test", "Test Brand",
                "Test Category", "Test SubCategory");

        assertThat(product.getId()).isNotNull();
        assertThat(product.getName()).isEqualTo("Test Product");
        assertThat(product.getDescription()).isEqualTo("Test");
        assertThat(product.getBrand()).isEqualTo("Test Brand");
        assertThat(product.getCategory()).isEqualTo("Test Category");
        assertThat(product.getSubCategory()).isEqualTo("Test SubCategory");
    }

    @Test
    void update() {
        Product product = new Product("Test Product", "Test", "Test Brand",
                "Test Category", "Test SubCategory");
        product.update("TestTest Product", "TestTest");

        assertThat(product.getName()).isEqualTo("TestTest Product");
        assertThat(product.getDescription()).isEqualTo("TestTest");
    }

}
