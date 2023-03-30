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
public class OrderItemId implements Serializable {

    private String id;

    public static OrderItemId of(String id) {
        return new OrderItemId(id);
    }

    public static OrderItemId generate() {
        return new OrderItemId(TsidCreator.getTsid().toString());
    }

    @Override
    public String toString() {
        return id;
    }

}
