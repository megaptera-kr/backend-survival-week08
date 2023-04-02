package kr.megaptera.assignment.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Cart {

    @EmbeddedId
    private CartId id;

    @ColumnDefault("1")
    private String accountId;

    @ManyToOne
    private Item item;

    private Integer count;

    private LocalDateTime updateDateTime;

    public Cart(String accountId, Item item, Integer count) {
        this.id = CartId.generate();
        this.item = item;
        this.accountId = accountId;
        this.count = count;
        this.updateDateTime = LocalDateTime.now();
    }

    public void update(Integer count) {
        this.count = count;
        this.updateDateTime = LocalDateTime.now();
    }

}
