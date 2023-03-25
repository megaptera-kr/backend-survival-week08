package kr.megaptera.assignment.model;

import com.github.f4b6a3.tsid.TsidCreator;

import java.io.Serializable;
import java.util.Objects;

public class CartItemId implements Serializable {
  private String value;

  public CartItemId(String value) {
    this.value = value;
  }

  public static CartItemId generate() {
    return new CartItemId(TsidCreator.getTsid().toString());
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
    if (!(o instanceof CartItemId that)) {
      return false;
    }

    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }
}
