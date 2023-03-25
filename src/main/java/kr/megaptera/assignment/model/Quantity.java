package kr.megaptera.assignment.model;

public class Quantity {
  private int value;

  public Quantity(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("Quantity must be greater or equal than 0");
    }
    this.value = value;
  }

  public int getValue() {
    return value;
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
    if (!(o instanceof Quantity quantity)) {
      return false;
    }

    return value == quantity.value;
  }

  @Override
  public int hashCode() {
    return value;
  }
}
