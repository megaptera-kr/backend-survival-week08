package kr.megaptera.assignment.model;

import com.github.f4b6a3.tsid.TsidCreator;

import java.util.Objects;

public class ProductId {
  private String value;

  public ProductId(String value) {
    this.value = value;
  }

  public static ProductId of(String value) {
    return new ProductId(value);
  }

  public static ProductId generate() {
    return new ProductId(TsidCreator.getTsid().toString());
  }

  @Override
  public String toString() {
    return this.value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ProductId productId)) {
      return false;
    }

    return Objects.equals(value, productId.value);
  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }
}
