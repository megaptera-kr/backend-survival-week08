package kr.megaptera.assignment.models;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class ProductId extends EntityId {
    protected ProductId() {
        super();
    }

    protected ProductId(UUID value) {
        super(value);
    }

    public static ProductId generate() {
        return new ProductId(newUlid());
    }

    public static ProductId of(UUID value) {
        return new ProductId(value);
    }

    public static ProductId of(String value) {
        return new ProductId(fromString(value));
    }
}
