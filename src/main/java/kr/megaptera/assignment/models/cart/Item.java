package kr.megaptera.assignment.models.cart;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import kr.megaptera.assignment.models.products.Product;

@Entity
public class Item {

    @EmbeddedId
    private ItemId id;

    private Product product;

    @Embedded
    private Quantity quantity;

    private Item() {
    }

    public Item(Product product, long quantity) {
        this.id = new ItemId(product.id().getId());
        this.product = product;
        this.quantity = Quantity.of(quantity);
    }

    public ItemId getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void changeQuantity(long quantity) {
        this.quantity = Quantity.of(quantity);
    }
}
