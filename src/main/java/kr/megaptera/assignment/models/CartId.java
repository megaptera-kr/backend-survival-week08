package kr.megaptera.assignment.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class CartId extends EntityId {
    public static final CartId DEFAULT = new CartId("0BV000000CART");

    public CartId() {
        super();
    }
    public CartId(String value) {
        super(value);
    }
    public static CartId generate() {
        return new CartId(newTsid());
    }
}
