package kr.megaptera.assignment.product.domain;

import jakarta.persistence.Embeddable;
import kr.megaptera.assignment.common.domain.EntityId;
@Embeddable
public class ProductId extends EntityId {
    public ProductId() {
        super();
    }

    public ProductId(String value) {
        super(value);
    }

    public static ProductId generate() {
        return new ProductId(newTsid());
    }
}
