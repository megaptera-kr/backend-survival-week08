package kr.megaptera.assignment.models.lineItems;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import kr.megaptera.assignment.models.products.Product;

@Embeddable
public class Item {

    @Embedded
    private Product product;

    @Column(name = "quantity")
    private long quantity;

    private Item() {
    }

    public Item(Product product, long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void changeQuantity(long quantity) {
        this.quantity = quantity;
    }
}
