package kr.megaptera.assignment.models.products;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Product implements Serializable {

    @EmbeddedId
    private ProductId id;

    @Embedded
    private ProductName name;

    @Embedded
    private Price price;

    public ProductId id() {
        return id;
    }

    public ProductName name() {
        return name;
    }

    public Price price() {
        return price;
    }

    public Product() {
    }

    public Product(ProductId id, ProductName name, Price price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(ProductName name, Price price) {
        this.id = new ProductId();
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
