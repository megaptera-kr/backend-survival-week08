package kr.megaptera.assignment.product.domain;

import java.time.LocalDateTime;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import kr.megaptera.assignment.product.dto.ProductResponse;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "products")
public class Product {
    @EmbeddedId
    private ProductId id;

    @Column(name = "name")
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "price"))
    private Money price;

    public Product() {
    }

    public Product(ProductId id, String name, Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Product create(String name, Money price) {
        return new Product(ProductId.generate(), name, price);
    }

    public ProductId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Money price() {
        return price;
    }

    public ProductResponse toResponse() {
        return new ProductResponse(
                this.id.toString(), // ID를 문자열로 변환
                this.name,
                this.price.getValue() // Money 객체를 적절한 문자열 표현으로 변환
        );
    }
}