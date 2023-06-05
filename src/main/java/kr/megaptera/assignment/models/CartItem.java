package kr.megaptera.assignment.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
    @EmbeddedId
    private CartItemId cartItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private Long quantity;

    public CartItem() {
    }

    public CartItem(CartItemId cartItemId, Cart cart, Product product, Long quantity) {
        this.cartItemId = cartItemId;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(Cart cart, Product product, Long quantity) {
        this.cartItemId = CartItemId.generate();
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public CartItemId cartItemId() {
        return cartItemId;
    }

    public Cart cart() {
        return cart;
    }

    public Product product() {
        return product;
    }

    public Long qantity() {
        return quantity;
    }

    public Long unitPrice() {
        return product.price();
    }

    public Long totalPrice() {
        return quantity * product.price();
    }

    public void updateCartItem(Long quantity) {
        this.quantity = quantity;
    }
}
