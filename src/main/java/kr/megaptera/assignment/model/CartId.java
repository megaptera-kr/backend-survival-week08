package kr.megaptera.assignment.model;

import com.github.f4b6a3.tsid.TsidCreator;

import java.io.Serializable;
import java.util.Objects;

public class CartId implements Serializable {
  private String value;

  public CartId(String value) {
    this.value = value;
  }

  public static CartId of(String value) {
    return new CartId(value);
  }

  public static CartId generate() {
    return new CartId(TsidCreator.getTsid().toString());
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
    if (!(o instanceof CartId cartId)) {
      return false;
    }

    return Objects.equals(value, cartId.value);
  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }
}
