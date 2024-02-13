package kr.megaptera.assignment.models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product implements ReadOnlyProduct {
    @EmbeddedId
    private ProductId productId;
    @Embedded
    private ProductName productName;
    @Embedded
    private Price price;

    protected Product() {
    }

    protected Product(ProductId productId, ProductName productName, Price price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public static Product of(ProductId productId, ProductName productName, Price price) {
        return new Product(productId, productName, price);
    }

    public static Product create(ProductName productName, Price price) {
        return new Product(ProductId.generate(), productName, price);
    }

    public ProductId getProductId() {
        return productId;
    }

    public ProductName getProductName() {
        return productName;
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
               "productId=" + productId +
               ", productName=" + productName +
               ", price=" + price +
               '}';
    }
}
