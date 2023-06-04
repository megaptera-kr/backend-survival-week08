package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartId implements Serializable {

    private String id;

    public CartId(String id) {
        this.id = id;
    }

    protected CartId() {
    }

    public static CartId of(String id) {
        return new CartId(id);
    }

    public static CartId generate() {
        return new CartId(TsidCreator.getTsid().toString());
    }

    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartId cartId = (CartId) o;
        return Objects.equals(id, cartId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
