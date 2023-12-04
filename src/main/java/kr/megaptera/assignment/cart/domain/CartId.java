package kr.megaptera.assignment.cart.domain;

import jakarta.persistence.Embeddable;
import kr.megaptera.assignment.common.domain.EntityId;

@Embeddable
public class CartId extends EntityId {
    public static final CartId DEFAULT = new CartId("CART_DEFAULT_ID");

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
