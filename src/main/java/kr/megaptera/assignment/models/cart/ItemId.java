package kr.megaptera.assignment.models.cart;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemId implements Serializable {

    @Column(name = "id")
    private String id;

    public ItemId() {
        this.id = generate();
    }

    public static ItemId of(String id) {
        return new ItemId(id);
    }

    public ItemId(String id) {
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
        if (!(o instanceof ItemId productId)) return false;
        return Objects.equals(id, productId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
