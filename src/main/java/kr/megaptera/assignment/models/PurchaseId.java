package kr.megaptera.assignment.models;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PurchaseId extends EntityId {

    public PurchaseId(String id) {
        super(id);
    }

    public static PurchaseId of(String id) {
        return new PurchaseId(id);
    }

    public static PurchaseId generate() {
        return new PurchaseId(newTsid());
    }

}
