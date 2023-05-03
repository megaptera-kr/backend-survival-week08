package kr.megaptera.assignment.domains.products;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
public class ProductId {
    @Column
    private String id;

    public ProductId(){
        id = TsidCreator.getTsid().toString();
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
