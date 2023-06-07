package kr.megaptera.assignment.models.cart;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartId implements Serializable {

    public static String DEFALUT = "ONLY";

    @Column(name = "id")
    private final String id;

    public CartId() {
        this.id = generate();
    }

    public CartId(String id) {
        this.id = id;
    }

    public static CartId of(String id) {
        return new CartId(id);
    }

    public String generate() {
        return DEFALUT;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartId productId)) return false;
        return Objects.equals(id, productId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
