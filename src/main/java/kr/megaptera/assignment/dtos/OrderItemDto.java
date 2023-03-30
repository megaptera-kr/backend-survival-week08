package kr.megaptera.assignment.dtos;

import jakarta.persistence.*;
import kr.megaptera.assignment.models.Item;
import kr.megaptera.assignment.models.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

    private String id;

    private Integer count;

    private LocalDateTime updateDateTime;

    private LocalDateTime shippingDateTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Item item;

}
