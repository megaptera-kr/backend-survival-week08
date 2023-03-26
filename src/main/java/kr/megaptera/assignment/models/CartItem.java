package kr.megaptera.assignment.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "products_id")
    private Product product;
    private Long count;
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "unit_price"))
    private Price unitPrice = Price.won(0D);
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "total_price"))
    private Price totalPrice = Price.won(0D);

    protected CartItem() {
    }

    public CartItem(Long id, Product product, Long count, Price unitPrice, Price totalPrice) {
        this.id = id;
        this.product = product;
        this.count = count;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Long getCount() {
        return count;
    }

    public Price getUnitPrice() {
        return unitPrice;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }
}
