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
public class CartId implements Serializable {

    private String id;

    public static CartId of(String id) {
        return new CartId(id);
    }

    public static CartId generate() {
        return new CartId(TsidCreator.getTsid().toString());
    }

    @Override
    public String toString() {
        return id;
    }

}
