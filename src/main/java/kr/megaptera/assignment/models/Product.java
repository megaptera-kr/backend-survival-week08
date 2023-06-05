package kr.megaptera.assignment.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    @EmbeddedId
    private ProductId id;

    @Embedded
    private ProductName productName;

    @Embedded
    private ProductPrice productPrice;

    public Product() {
    }

    public Product(ProductId id, ProductName productName, ProductPrice productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product(ProductName productName, ProductPrice productPrice) {
        this.id = ProductId.generate();
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(productName, product.productName) && Objects.equals(productPrice, product.productPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productPrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName=" + productName +
                ", productPrice=" + productPrice +
                '}';
    }

    public ProductId id() {
        return id;
    }

    public ProductName productName() {
        return productName;
    }

    public ProductPrice productPrice() {
        return productPrice;
    }
}
