package kr.megaptera.assignment.models.products;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductId implements Serializable {

    @Column(name = "id")
    private String id;

    public ProductId() {
        this.id = generate();
    }

    public static ProductId of(String id) {
        return new ProductId(id);
    }

    public ProductId(String id) {
        this.id = id;
    }

    public String generate() {
        return TsidCreator.getTsid().toString();
    }

    public String getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductId productId)) return false;
        return Objects.equals(id, productId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
