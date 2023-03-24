package kr.megaptera.assignment.Models.cart;

import jakarta.persistence.*;
import kr.megaptera.assignment.Models.product.*;

import java.util.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "user_id")
    private String userId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    @OrderBy("id")
    private List<Product> products;

    public Cart() {
    }

    public Cart(String userId) {
        this.userId = userId;
    }

    public List<Product> getItems() {
        return new ArrayList<>(products);
    }

    public void addProductInCart(Product product) {
        if (products.contains(product)) {
            int idx = products.indexOf(product);
            int sum = products.get(idx).quantity().quantity() +
                    product.quantity().quantity();
            if (sum > 0) {
                products.get(idx).updateQuantity(sum);
            } else {
                products.remove(idx);
            }
        } else {
            products.add(product);
        }
    }
}
