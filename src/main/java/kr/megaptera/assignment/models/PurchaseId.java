package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PurchaseId implements Serializable {

    private String id;

    public static PurchaseId of(String id) {
        return new PurchaseId(id);
    }

    public static PurchaseId generate() {
        return new PurchaseId(TsidCreator.getTsid().toString());
    }

    @Override
    public String toString() {
        return id;
    }

}
