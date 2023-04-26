package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.*;
import jakarta.persistence.*;

import java.util.*;

@Embeddable
public class ProductId {

    @Column(name = "product_id")
    private String value;

    public ProductId() {
    }

    public ProductId(String value) {
        this.value = value;
    }

    public static ProductId generate(){
        return new ProductId(TsidCreator.getTsid().toString());
    }

    public static ProductId of(String value){
        return new ProductId(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(value, productId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}

