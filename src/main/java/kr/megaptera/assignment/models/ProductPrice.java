package kr.megaptera.assignment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ProductPrice {
    @Column(name = "product_price")
    private Long price;

    public ProductPrice() {
    }

    public ProductPrice(Long price) {
        this.price = price;
    }

    public static ProductPrice of(Long price) {
        return new ProductPrice(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPrice that = (ProductPrice) o;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return Long.toString(price);
    }
}
