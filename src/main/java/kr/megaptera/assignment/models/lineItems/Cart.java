package kr.megaptera.assignment.models.lineItems;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import kr.megaptera.assignment.models.products.Product;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class Cart {

    @Id
    @Column(name = "id")
    private long id;

    @OneToMany
    @JoinColumn
    @OrderBy("product")
    private List<Item> lineItems;

    private Cart() {
    }

    public Cart(long id, List<Item> lineItems) {
        this.id = id;
        this.lineItems = lineItems;
    }

    public long getId() {
        return id;
    }

    public List<Item> getLineItems() {
        return lineItems;
    }

    public void addItem(Product product, long quantity) {
        Item item = new Item(product, quantity);
        lineItems.add(item);
    }

    public void changeItemQuantity(String id, long quantity) {
        Item item = lineItems
                .stream()
                .filter(
                        i -> i.getProduct().getId().getId().equals(id)
                ).findFirst()
                .orElseThrow();
        item.changeQuantity(quantity);
    }
}
