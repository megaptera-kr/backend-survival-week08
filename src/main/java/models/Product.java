package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "id")
    private java.lang.String id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;

    public Product() {
    }

    public Product(String id) {
        this.id = id;
    }

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public java.lang.String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public int price() {
        return price;
    }
}
