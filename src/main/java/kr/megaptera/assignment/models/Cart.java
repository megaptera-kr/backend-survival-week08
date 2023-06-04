package kr.megaptera.assignment.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @EmbeddedId
    private CartId id;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "product_id")
//    @OrderBy("name")
    private List<CartItem> cartItems = new ArrayList<>();

    public Cart() {
    }

    public Cart(List<CartItem> cartItems) {
        this.id = CartId.generate();
        this.cartItems = cartItems;
    }

    public Cart(CartId id, List<CartItem> cartItems) {
        this.id = id;
        this.cartItems = cartItems;
    }

    public CartId id() {
        return id;
    }

    public List<CartItem> cartItems() {
        return new ArrayList<>(cartItems);
    }

    public void updateItemQuantity(Product product, int quantity) {
        CartItem existingItem = findCartItemByProduct(product);
        if (existingItem != null) {
            existingItem.updateQuantity(quantity);
        }
    }

    private CartItem findCartItemByProduct(Product product) {
        return cartItems.stream()
                .filter(item -> item.product().equals(product))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartItems=" + cartItems +
                '}';
    }
}
