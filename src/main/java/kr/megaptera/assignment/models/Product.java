package kr.megaptera.assignment.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kr.megaptera.assignment.dtos.CreateProductRequest;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OptionGroup> optionGroups = new ArrayList<>();

    private LocalDateTime created_datetime;
    private LocalDateTime updated_datetime;

    protected Product() {
    }

    public Product(String name, String description, LocalDateTime created_datetime,
            LocalDateTime updated_datetime) {
        this.name = name;
        this.description = description;
        this.created_datetime = created_datetime;
        this.updated_datetime = updated_datetime;
    }

    public Product(Long id, String name, String description, List<OptionGroup> optionGroups,
            LocalDateTime created_datetime, LocalDateTime updated_datetime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.optionGroups = optionGroups;
        this.created_datetime = created_datetime;
        this.updated_datetime = updated_datetime;
    }

    public static Product create(CreateProductRequest request) {
        List<Map<String, Map<String, Double>>> optionGroupInfo = request.getOptionGroups();

        Product product = new Product(request.getName(), request.getDescription(),
                LocalDateTime.now(), LocalDateTime.now());
        List<OptionGroup> optionGroups = product.optionGroups;

        for (Map<String, Map<String, Double>> info : optionGroupInfo) {
            for (String groupName : info.keySet()) {
                Map<String, Double> optionMap = info.get(groupName);

                optionGroups.add(OptionGroup.create(product, groupName, optionMap));
            }
        }
        return product;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<OptionGroup> getOptionGroups() {
        return optionGroups;
    }

    public LocalDateTime getCreated_datetime() {
        return created_datetime;
    }

    public LocalDateTime getUpdated_datetime() {
        return updated_datetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
