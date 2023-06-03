package kr.megaptera.assignment.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

    @EmbeddedId
    private CartId id;

    @Column(name = "product_name")
    private String ProductName;

    private Long quantity;

    @Column(name = "total_price")
    private Long totalPrice;

    @Column(name = "unit_price")
    private Long unitPrice;

    protected Cart() {
    }

    public Cart(CartId id, String ProductName, Long quantity, Long totalPrice, Long unitPrice) {
        this.id = id;
        this.ProductName = ProductName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.unitPrice = unitPrice;
    }

    public Cart(String ProductName, Long quantity, Long totalPrice, Long unitPrice) {
        this.id = CartId.generate();
        this.ProductName = ProductName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.unitPrice = unitPrice;
    }

    public static Cart of(String ProductName, Long quantity, Long totalPrice, Long unitPrice) {
        return new Cart(ProductName, quantity, totalPrice, unitPrice);
    }

    public CartId Id() {
        return id;
    }

    public String ProductName() {
        return ProductName;
    }

    public Long Quantity() {
        return quantity;
    }

    public Long TotalPrice() {
        return totalPrice;
    }

    public Long UnitPrice() {
        return unitPrice;
    }

    public boolean isEqualId(CartId id) {
        return this.id.equals(id);
    }

    public void updateQuantity(Long quantity) {
        this.quantity = quantity;
        this.totalPrice = this.unitPrice * this.quantity;
    }
}
