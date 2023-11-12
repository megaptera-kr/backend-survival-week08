package kr.megaptera.assignment.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column
    String name;
    @Column
    Long price;

    private Product() {
    }

    public Product(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }
}
