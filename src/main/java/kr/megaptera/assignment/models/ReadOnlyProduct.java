package kr.megaptera.assignment.models;

public interface ReadOnlyProduct {
    ProductId getProductId();

    ProductName getProductName();

    Price getPrice();
}
