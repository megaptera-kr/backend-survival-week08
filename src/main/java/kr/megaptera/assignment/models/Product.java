package kr.megaptera.assignment.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

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

    private LocalDateTime regDateTime;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    public Product(String name, String description, String brand, String category, String subCategory) {
        this.id = ProductId.generate();
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.subCategory = subCategory;
        this.regDateTime = LocalDateTime.now();
    }

    public void update(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
