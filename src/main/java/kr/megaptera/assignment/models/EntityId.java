package kr.megaptera.assignment.models;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public abstract class EntityId implements Serializable {

    private String id;

    protected static String newTsid() {
        return TSID.Factory.getTsid().toString();
    }

    @Override
    public String toString() {
        return id;
    }

}
