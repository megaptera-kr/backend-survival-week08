package kr.megaptera.assignment.Models.product;

import com.github.f4b6a3.tsid.*;
import jakarta.persistence.*;

import java.util.*;

@Embeddable
public class ProductId {
    @Column(name = "id")
    private String id;

    public static ProductId generate() {
        return new ProductId(TsidCreator.getTsid().toString());
    }

    public ProductId() {
    }

    public ProductId(String id) {
        this.id = id;
    }

    public static ProductId of(String id) {
        return new ProductId(id);
    }

    @Override
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
