package kr.megaptera.assignment.product.domain;

import com.github.f4b6a3.tsid.Tsid;
import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.*;
import kr.megaptera.assignment.product.dto.ProductResponse;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(name = "products")
public class ProductEntity {
        @Id
        @Column(name = "id")
        private String id;

        @Column(name = "name")
        private String name;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;

        @Embedded
        @AttributeOverride(name = "value", column = @Column(name = "price"))
        private Money price;

        public ProductEntity() {
        }

        public ProductEntity(String id, String name, Money price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public static ProductEntity create(String name, Money price) {
            return new ProductEntity(TsidCreator.getTsid256().toString(), name, price);
        }

    public static ProductResponse toResponse(ProductEntity entity) {
        return new ProductResponse(entity.getId(), entity.getName(), entity.getPrice().getValue());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}
