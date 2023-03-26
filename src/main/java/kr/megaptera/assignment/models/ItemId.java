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
public class ItemId implements Serializable {

    private String id;

    public static ItemId of(String id) {
        return new ItemId(id);
    }

    public static ItemId generate() {
        return new ItemId(TsidCreator.getTsid().toString());
    }

    @Override
    public String toString() {
        return id;
    }

}
