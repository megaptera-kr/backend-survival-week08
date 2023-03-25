package kr.megaptera.assignment.Models.cart;

import jakarta.persistence.*;
import kr.megaptera.assignment.Models.product.*;

import java.util.*;

@Entity
@Table(name = "cart")
public class Cart {

    @EmbeddedId
    private UserId userId;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    @OrderBy("id")
    private List<Product> products;

    public Cart() {
    }

    public Cart(UserId userId) {
        this.userId = userId;
    }

    public List<Product> getItems() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product, Integer quantity) {
        if (products.contains(product)) {
            product.updateQuantity(quantity);
        } else {
            products.add(
                    new Product(
                            product.id(),
                            this.userId,
                            product.type(),
                            product.name(),
                            product.price(),
                            Quantity.of(quantity),
                            product.content())
            );
        }
    }
}
