package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ProductId {
    @Column(name = "product_id")
    private String id;

    public ProductId() {
    }

    public ProductId(String id) {
        this.id = id;
    }

    public static ProductId of(String id) {
        return new ProductId(id);
    }

    public static ProductId generate() {
        return new ProductId(TsidCreator.getTsid().toString());
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

    @Override
    public String toString() {
        return id;
    }
}
