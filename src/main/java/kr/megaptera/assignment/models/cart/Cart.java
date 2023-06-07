package kr.megaptera.assignment.models.cart;

import jakarta.persistence.*;
import kr.megaptera.assignment.exceptions.ItemNotFound;
import kr.megaptera.assignment.models.products.Product;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @Column(name = "id")
    private CartId id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    @OrderBy("id")
    private List<Item> lineItems;

    private Cart() {
    }

    public Cart(CartId id) {
        this.id = id;
        this.lineItems = new ArrayList<>();
    }

    public CartId id() {
        return id;
    }

    public List<Item> lineItems() {
        return lineItems;
    }

    public Item addItem(Product product, long quantity) {
        Item item = new Item(product, quantity);
        lineItems.add(item);
        return item;
    }

    public Item changeItemQuantity(String id, long quantity) {
        Item item = lineItems
                .stream()
                .filter(
                        i -> i.getProduct().id().getId().equals(id)
                ).findFirst()
                .orElseThrow(ItemNotFound::new);
        item.changeQuantity(quantity);
        return item;
    }

    public void removeItem(String id) {
        Item item = lineItems
                .stream()
                .filter(
                        i -> i.getProduct().id().getId().equals(id)
                ).findFirst()
                .orElseThrow(ItemNotFound::new);
        lineItems.remove(item);
    }
}
