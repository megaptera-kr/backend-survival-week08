package kr.megaptera.assignment.models;

import jakarta.persistence.*;

import java.security.*;

@Entity
public class Product {

    @EmbeddedId
    private ProductId id;

    private String name;

    private Long price;

    public Product() {
    }

    public Product(ProductId id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id.toString();
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
