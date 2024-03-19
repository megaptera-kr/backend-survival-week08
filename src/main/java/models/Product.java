package models;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    @OneToOne
    private Name name;
    @Column(name = "price")
    private int price;

    public Product(String id, Name name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String id() {
        return id;
    }

    public Name name() {
        return name;
    }

    public int price() {
        return price;
    }
}
