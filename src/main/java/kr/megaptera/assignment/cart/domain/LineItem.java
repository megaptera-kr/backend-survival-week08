package kr.megaptera.assignment.cart.domain;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import kr.megaptera.assignment.product.domain.Money;
import kr.megaptera.assignment.product.domain.Product;
import kr.megaptera.assignment.product.domain.ProductId;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "line_items")
public class LineItem {
    @EmbeddedId
    private LineItemId id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "product_id"))
    private ProductId productId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "unit_price"))
    private Money unitPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "total_price"))
    private Money totalPrice;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "product_name")
    private String productName;

    public LineItem() {
    }

    public LineItem(LineItemId id, Product product, int quantity) {
        this.id = id;
        this.productId = product.id();
        this.unitPrice = product.price();
        this.quantity = quantity;
        this.totalPrice = unitPrice.times(quantity);
        this.productName = product.name();
    }

    public static LineItem create(Product product, int quantity) {
        return new LineItem(LineItemId.generate(), product, quantity);
    }

    public LineItemId id() {
        return id;
    }

    public int quantity() {
        return quantity;
    }

    public Money totalPrice() {
        return totalPrice;
    }

    public boolean sameProduct(ProductId productId) {
        return this.productId.equals(productId);
    }

    public void increaseQuantity(int quantity) {
        if (quantity <= 0) {
            return;
        }

        setQuantity(this.quantity + quantity);
    }

    public void changeQuantity(int quantity) {
        setQuantity(quantity);
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalPrice = unitPrice.times(quantity);
    }

    public LineItemId getId() {
        return id;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Money getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Money getTotalPrice() {
        return totalPrice;
    }


    public String getProductName() {
        return productName;
    }
}
