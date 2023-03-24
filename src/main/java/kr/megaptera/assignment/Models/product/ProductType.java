package kr.megaptera.assignment.Models.product;

import jakarta.persistence.*;

import java.util.*;

@Embeddable
public class ProductType {
    private String type;

    public ProductType() {
    }

    public ProductType(String type) {
        this.type = type;
    }

    public static ProductType of(String type) {
        return new ProductType(type);
    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductType that = (ProductType) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
