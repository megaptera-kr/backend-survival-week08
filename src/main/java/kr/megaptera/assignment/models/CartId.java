package kr.megaptera.assignment.models;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class CartId extends EntityId {
    public static final CartId DEFAULT = new CartId(newUlid());

    protected CartId() {
        super();
    }

    protected CartId(UUID value) {
        super(value);
    }

    public static CartId generate() {
        return new CartId(newUlid());
    }
}
