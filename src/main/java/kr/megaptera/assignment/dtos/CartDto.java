package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Cart;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private String id;

    private String itemId;

    private Integer count;

    private LocalDateTime updateDate;

    public CartDto(Cart cart) {
        this(cart.getId().toString(), cart.getItem().getId().toString(),
                cart.getCount(), cart.getUpdateDate());
    }

}
