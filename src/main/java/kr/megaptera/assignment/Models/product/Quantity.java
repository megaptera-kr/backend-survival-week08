package kr.megaptera.assignment.Models.product;

import jakarta.persistence.*;

import java.util.*;

@Embeddable
public class Quantity {

    private Integer quantity;

    public Quantity() {
    }

    public Quantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static Quantity of(Integer quantity) {
        return new Quantity(quantity);
    }

    public Integer quantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "" + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity1 = (Quantity) o;
        return Objects.equals(quantity, quantity1.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
