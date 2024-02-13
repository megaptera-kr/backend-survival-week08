package kr.megaptera.assignment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ProductName {
    @Column(name = "product_name")
    private String value;

    protected ProductName() {
    }

    protected ProductName(String value) {
        this.value = value;
    }

    public static ProductName empty() {
        return new ProductName("");
    }

    public static ProductName of(String value) {
        return new ProductName(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductName that = (ProductName) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return "ProductName{" +
               "value='" + value + '\'' +
               '}';
    }
}
