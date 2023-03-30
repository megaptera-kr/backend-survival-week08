package kr.megaptera.assignment.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class OrderItem {

    @EmbeddedId
    private OrderItemId id;

    private Integer count;

    private LocalDateTime updateDateTime;

    private LocalDateTime shippingDateTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    private Item item;

}
