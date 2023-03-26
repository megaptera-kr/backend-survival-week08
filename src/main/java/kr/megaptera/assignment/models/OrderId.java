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
public class OrderId implements Serializable {

    private String id;

    public static OrderId of(String id) {
        return new OrderId(id);
    }

    public static OrderId generate() {
        return new OrderId(TsidCreator.getTsid().toString());
    }

    @Override
    public String toString() {
        return id;
    }

}
