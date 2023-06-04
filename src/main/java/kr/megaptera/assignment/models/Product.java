package kr.megaptera.assignment.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @EmbeddedId
    private ProductId id;

    private String name;

    private Long price;

    protected Product() {
    }

    public Product(ProductId id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, Long price) {
        this.id = ProductId.generate();
        this.name = name;
        this.price = price;
    }

    public static Product of(String name, Long price) {
        return new Product(name, price);
    }

    public ProductId Id() {
        return id;
    }

    public String Name() {
        return name;
    }

    public Long Price() {
        return price;
    }

    public boolean isEqualId(ProductId id) {
        return this.id.equals(id);
    }
}
