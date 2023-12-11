package kr.megaptera.assignment.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Embedded
    Name name;
    @Embedded
    Price price;

    private Product() {
    }

    public Product(Name name, Price price) {
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name.toString();
    }

    public Long getPrice() {
        return price.getValue();
    }
}
