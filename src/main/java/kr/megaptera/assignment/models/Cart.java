package kr.megaptera.assignment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "carts")
public class Cart {
    @EmbeddedId
    private ProductId id;
    @Embedded
    private ProductName name;
    @Column(name = "quantity")
    private Long quantity;
    @Embedded
    private ProductPrice unitPrice;
    @Column(name = "total_price")
    private Long totalPrice;

    public Cart() {
    }

    public Cart(ProductId id, ProductName name, Long quantity, ProductPrice unitPrice) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * Long.parseLong(unitPrice.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) && Objects.equals(name, cart.name) && Objects.equals(quantity, cart.quantity) && Objects.equals(unitPrice, cart.unitPrice) && Objects.equals(totalPrice, cart.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, unitPrice, totalPrice);
    }

    public ProductId id() {
        return id;
    }

    public ProductName name() {
        return name;
    }

    public Long quantity() {
        return quantity;
    }

    public ProductPrice unitPrice() {
        return unitPrice;
    }

    public Long totalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", name=" + name +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public void updateQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
