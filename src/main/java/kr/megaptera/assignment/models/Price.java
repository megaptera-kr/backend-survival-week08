package kr.megaptera.assignment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Price {
    @Column(name = "price")
    private Long value;

    public Long getValue() {
        return value;
    }

    protected Price() {
        this(0L);
    }

    protected Price(Long value) {
        this.value = value;
    }

    public static Price zero() {
        return new Price(0L);
    }

    public static Price of(Long value) {
        return new Price(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(getValue(), price.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return "Price{" +
               "value=" + value +
               '}';
    }
}
