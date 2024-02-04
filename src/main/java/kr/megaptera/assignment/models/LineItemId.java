package kr.megaptera.assignment.models;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class LineItemId extends EntityId {
    protected LineItemId() {
        super();
    }

    protected LineItemId(UUID value) {
        super(value);
    }

    public static LineItemId generate() {
        return new LineItemId(newUlid());
    }

    public static LineItemId of(UUID value) {
        return new LineItemId(value);
    }

    public static LineItemId of(String value) {
        return new LineItemId(fromString(value));
    }
}
