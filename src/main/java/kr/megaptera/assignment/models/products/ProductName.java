package kr.megaptera.assignment.models.products;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ProductName {

    @Column(name = "name")
    private String name;

    public ProductName() {
    }

    public ProductName(String name) {
        this.name = name;
    }

    public static ProductName of(String name) {
        return new ProductName(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductName that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
