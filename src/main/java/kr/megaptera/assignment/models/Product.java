package kr.megaptera.assignment.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Product {
    @EmbeddedId
    private ProductId productId;

    private String name;

    private Long price;

    public Product() {
    }

    public Product(ProductId productId, String name, Long price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Product(String name, Long price) {
        this.productId = ProductId.generate();
        this.name = name;
        this.price = price;
    }

    public ProductId productId() {
        return productId;
    }

    public String name() {
        return name;
    }

    public Long price() {
        return price;
    }
}
