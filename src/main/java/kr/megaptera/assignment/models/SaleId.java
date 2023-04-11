package kr.megaptera.assignment.models;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaleId extends EntityId {

    public SaleId(String id) {
        super(id);
    }

    public static SaleId of(String id) {
        return new SaleId(id);
    }

    public static SaleId generate() {
        return new SaleId(newTsid());
    }

}
