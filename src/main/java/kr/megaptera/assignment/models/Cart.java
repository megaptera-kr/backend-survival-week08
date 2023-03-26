package kr.megaptera.assignment.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Cart {

    @EmbeddedId
    private CartId id;

    private Integer count;

    private LocalDateTime updateDate;

    @ManyToOne
    private Item item;

    public Cart(Item item, Integer count) {
        this.id = CartId.generate();
        this.item = item;
        this.count = count;
        this.updateDate = LocalDateTime.now();
    }

    public void update(Integer count) {
        this.count = count;
        this.updateDate = LocalDateTime.now();
    }

}
