package kr.megaptera.assignment.cart.domain;

import jakarta.persistence.Embeddable;
import kr.megaptera.assignment.common.domain.EntityId;

@Embeddable
public class LineItemId extends EntityId {
    public LineItemId() {
        super();
    }

    public LineItemId(String value) {
        super(value);
    }

    public static LineItemId generate() {
        return new LineItemId(newTsid());
    }
}
