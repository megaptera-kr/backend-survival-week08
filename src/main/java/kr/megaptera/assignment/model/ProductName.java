package kr.megaptera.assignment.model;

import io.micrometer.common.util.StringUtils;

import java.util.Objects;

public class ProductName {
  private String value;

  public ProductName(String value) {
    if (StringUtils.isBlank(value)) {
      throw new IllegalArgumentException("Product Name can't be blank");
    }
    this.value = value;
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
    if (!(o instanceof ProductName that)) {
      return false;
    }

    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }
}
