package kr.megaptera.assignment.models;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PurchaseItemId extends EntityId {

    public PurchaseItemId(String id) {
        super(id);
    }

    public static PurchaseItemId of(String id) {
        return new PurchaseItemId(id);
    }

    public static PurchaseItemId generate() {
        return new PurchaseItemId(newTsid());
    }

}
