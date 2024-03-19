package models;

import dtos.CartInsertDto;
import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "user_id")
    private String id;
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Product product;

    private int quantity;
    private int unitPrice;
    private int totalPrice;

    public Cart(String id, Product product, int quantity, int unitPrice) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = unitPrice * quantity;
    }

    public String id() {
        return id;
    }

    public Product product() {
        return product;
    }

    public int quantity() {
        return quantity;
    }

    public int unitPrice() {
        return unitPrice;
    }

    public void addItem(CartInsertDto dto) {

    }
}
