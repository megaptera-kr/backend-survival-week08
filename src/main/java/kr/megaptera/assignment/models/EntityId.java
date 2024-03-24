package kr.megaptera.assignment.models;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;

@MappedSuperclass
public abstract class EntityId { //여러 id클래스의 로직을 중복작성하지 않기 위해 해당 클래스 생성.

    @Column(name = "id")
    private String value;
    protected EntityId() {
    }
    protected EntityId(String value) {
        this.value = value;
    }

    protected static String newTsid() {
        return TSID.Factory.getTsid().toString();
    }
    @Override
    public String toString() {
        return value;
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
