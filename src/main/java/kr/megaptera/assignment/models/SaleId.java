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
public class SaleId implements Serializable {

    private String id;

    public static SaleId of(String id) {
        return new SaleId(id);
    }

    public static SaleId generate() {
        return new SaleId(TsidCreator.getTsid().toString());
    }

    @Override
    public String toString() {
        return id;
    }

}
