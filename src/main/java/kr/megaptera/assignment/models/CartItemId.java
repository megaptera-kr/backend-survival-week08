package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;

import java.util.Objects;

public class CartItemId {
    private String value;

    public CartItemId() {
    }

    public CartItemId(String value) {
        this.value = value;
    }

    public static CartItemId generate() {
        return new CartItemId(TsidCreator.getTsid().toString());
    }

    public static CartItemId of(String cartItemId) {
        return new CartItemId(cartItemId);
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
        CartItemId that = (CartItemId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
