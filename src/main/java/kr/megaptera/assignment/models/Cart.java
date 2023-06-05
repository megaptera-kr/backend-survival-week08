package kr.megaptera.assignment.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Cart {
    @EmbeddedId
    private CartId cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart(CartId cartId, List<CartItem> cartItems) {
        this.cartId = cartId;
        this.cartItems = cartItems;
    }

    public void addCartItem(Product product, Long quantity) {
        CartItem cartItem = new CartItem(this, product, quantity);
        cartItems.add(cartItem);
    }

    public CartId cartId() {
        return cartId;
    }

    public List<CartItem> cartItems() {
        return cartItems;
    }
}
