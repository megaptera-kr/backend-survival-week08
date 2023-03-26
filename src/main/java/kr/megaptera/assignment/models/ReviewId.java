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
public class ReviewId implements Serializable {

    private String id;

    public static ReviewId of(String id) {
        return new ReviewId(id);
    }

    public static ReviewId generate() {
        return new ReviewId(TsidCreator.getTsid().toString());
    }

    @Override
    public String toString() {
        return id;
    }

}
