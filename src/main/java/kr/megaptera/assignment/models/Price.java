package kr.megaptera.assignment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class Price {
    @Column(name = "price")
    private final BigDecimal value;

    protected Price() {
        value = BigDecimal.ZERO;
    }

    protected Price(BigDecimal value) {
        this.value = value;
    }

    public static Price won(Double value) {
        return new Price(BigDecimal.valueOf(value));
    }

    public Price plus(Price price) {
        return new Price(this.value.add(price.value));
    }

    public Price minus(Price price) {
        return new Price(this.value.subtract(price.value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price price = (Price) o;
        return value.equals(price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString() + "원";
    }

    public BigDecimal getValue() {
        return value;
    }
}


