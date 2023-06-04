package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Optional;


@Entity
@Table(name = "cart")
public class Cart {
    @EmbeddedId
    private CartId id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    @OrderBy("id")
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart(CartId id, List<CartItem> cartItems) {
        this.id = id;
        this.cartItems = cartItems;
    }

    public static CartId of(String value) {
        return new CartId(value);
    }

    public static CartId generate() {
        return new CartId(TsidCreator.getTsid().toString());
    }

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            return;
        }

        Optional<CartItem> found = findLineItem(product.id());

        if (found.isPresent()) {
            LineItem lineItem = found.get();
            lineItem.increaseQuantity(quantity);
            return;
        }

        LineItem lineItem = LineItem.create(product, quantity);

        lineItems.add(lineItem);
    }

//    public void removeItem(Product product) {
//        cartItems.removeIf(item -> item.getProduct().getId().equals(product.getId()));
//    }

    public void updateQuantity(Product product, int quantity) {
        Optional<CartItem> existingItem = cartItems.stream()
                .filter(item -> item.product().id().equals(product.id()))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.updateQuantity(quantity);
        }
    }

    public List<CartItem> getItems() {
        return cartItems;
    }

    public Long getTotalPrice() {
        return cartItems.stream()
                .mapToLong(item -> item.product().price() * item.quantity())
                .sum();
    }

    public Optional<CartItem> findLineItem(ProductId productId) {
        return cartItems.stream()
                .filter(item -> item.sameProduct(productId))
                .findFirst();
    }

    public Optional<CartItem> findLineItem(CartItemId lineItemId) {
        return cartItems.stream()
                .filter(item -> item.id().equals(lineItemId))
                .findFirst();
    }
}
