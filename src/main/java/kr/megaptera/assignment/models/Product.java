package kr.megaptera.assignment.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private CartLineItem cartLineItem;

    public Product(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Long price() {
        return price;
    }

    public CartLineItem cartLineItem() {
        return cartLineItem;
    }

    public void updateCartLineItemQuantity(Long quantity) {
        if (quantity <= 0) {
            this.cartLineItem = null;
            return;
        }

        if (cartLineItem == null) {
            cartLineItem = new CartLineItem(this, quantity);
        } else {
            cartLineItem.setQuantity(quantity);
        }

    }
}
