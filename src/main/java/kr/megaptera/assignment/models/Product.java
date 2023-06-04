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

    public Product() {
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

    public ProductId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Long price() {
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
