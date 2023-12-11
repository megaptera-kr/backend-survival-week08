package kr.megaptera.assignment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_line_items")
public class CartLineItem {
    @Id
    private Long id;

    @OneToOne
    @MapsId //기본 키를 공유하도록 설정
    @JoinColumn(name = "id")
    private Product product;

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
        applyQuantityChange();
    }

    private Long quantity;

    private Long totalPrice;

    private Long unitPrice;

    public CartLineItem() {
    }

    public CartLineItem(Product product, Long quantity) {
        this.product = product;
        this.quantity = quantity;
        applyQuantityChange();
    }

    public Long id() {
        return id;
    }

    public Product product() {
        return product;
    }

    public Long quantity() {
        return quantity;
    }

    public Long totalPrice() {
        return totalPrice;
    }

    public Long unitPrice() {
        return unitPrice;
    }

    private void applyQuantityChange() {
        this.unitPrice = product.price();
        this.totalPrice = this.quantity * this.unitPrice;
    }

    @Override
    public String toString() {
        return "CartLineItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", unitPrice=" + unitPrice +
                '}';
    }

}
