package kr.megaptera.assignment.models.products;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Price {

    @Column(name = "price")
    private final long value;

    public Price(long value) {
        this.value = value;
    }

    public static Price of(long value) {
        return new Price(value);
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price price)) return false;
        return value == price.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
