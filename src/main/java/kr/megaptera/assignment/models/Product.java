package kr.megaptera.assignment.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Product {

    @EmbeddedId
    private ProductId id;

    private String name;

    private String description;

    private String brand;

    private String category;

    private String subCategory;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    public Product(String name, String description, String brand, String category, String subCategory) {
        this.id = ProductId.generate();
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.subCategory = subCategory;
    }

    public Product(ProductId id, String name, String description, String brand, String category, String subCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.subCategory = subCategory;
    }

    public void update(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
