package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductId implements Serializable {

    private String id;

    public ProductId(String id) {
        this.id = id;
    }

    protected ProductId() {
    }

    public static ProductId of(String id) {
        return new ProductId(id);
    }

    public static ProductId generate() {
        return new ProductId(TsidCreator.getTsid().toString());
    }

    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(id, productId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
