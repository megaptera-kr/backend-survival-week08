package kr.megaptera.assignment.models;

import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class EntityId implements Serializable {
    @Column(name = "id")
    private UUID value;

    protected EntityId() {

    }

    protected EntityId(UUID value) {
        this.value = value;
    }

    protected static UUID newUlid() {
        return UlidCreator.getMonotonicUlid().toUuid();
    }

    protected static UUID fromString(String value) {
        return UUID.fromString(value);
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value == null ? "<null>" : value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityId entityId = (EntityId) o;
        return Objects.equals(value, entityId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
