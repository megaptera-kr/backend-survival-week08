package kr.megaptera.assignment.model;

public class UnitPrice {
  private int value;

  public UnitPrice(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("Quantity must be greater or equal than 0");
    }
    this.value = value;
  }

  @Override
  public String toString() {
    return "" + this.value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UnitPrice unitPrice)) {
      return false;
    }

    return value == unitPrice.value;
  }

  @Override
  public int hashCode() {
    return value;
  }
}
