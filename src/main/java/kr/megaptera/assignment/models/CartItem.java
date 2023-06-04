package kr.megaptera.assignment.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @EmbeddedId
    private CartItemId id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    public CartItem() {
    }

    public CartItem(Product product, int quantity) {
        this.id = CartItemId.generate();
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(CartItemId id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public CartItemId id() {
        return id;
    }

    public Product product() {
        return product;
    }

    public int quantity() {
        return quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long totalPrice() {
        return product.price() * quantity;
    }

    public Long unitPrice() {
        return product.price();
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
