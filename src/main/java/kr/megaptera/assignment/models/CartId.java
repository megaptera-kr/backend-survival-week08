package kr.megaptera.assignment.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class CartId extends EntityId{

    public static final CartId DEFAULT = new CartId("00000000000001");

    private CartId() {
        super();
    }

    public CartId(String value) {
        super(value);
    }

    public static CartId generate() {
        return new CartId(newTsid());
    }
}
