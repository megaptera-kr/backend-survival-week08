package kr.megaptera.assignment.models;

import io.hypersistence.tsid.TSID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductId extends EntityId {

    public ProductId(String id) {
        super(id);
    }

    public static ProductId of(String id) {
        return new ProductId(id);
    }

    public static ProductId generate() {
        return new ProductId(newTsid());
    }

}
