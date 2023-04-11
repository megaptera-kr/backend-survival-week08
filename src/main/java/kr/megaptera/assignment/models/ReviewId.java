package kr.megaptera.assignment.models;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewId extends EntityId {

    public ReviewId(String id) {
        super(id);
    }

    public static ReviewId of(String id) {
        return new ReviewId(id);
    }

    public static ReviewId generate() {
        return new ReviewId(newTsid());
    }

}
