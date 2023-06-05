package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class CartId {
    @Column(name = "cart_id")
    private String value;

    public CartId() {
    }

    public CartId(String value) {
        this.value = value;
    }

    public static CartId of(String value) {
        return new CartId(value);
    }

    public static CartId generate() {
        return new CartId(TsidCreator.getTsid().toString());
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartId cartId = (CartId) o;
        return Objects.equals(value, cartId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
