package kr.megaptera.assignment.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Sale {

    @EmbeddedId
    private SaleId id;

    private Integer count;

    @ManyToOne
    private Purchase purchase;

    @ManyToOne
    private Item item;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
