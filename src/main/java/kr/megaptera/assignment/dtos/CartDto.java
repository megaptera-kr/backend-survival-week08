package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.ItemId;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private String id;

    private String accountId;

    private String itemId;

    private Integer count;

    public CartDto(Cart cart) {
        this(cart.getId().toString(), cart.getAccountId(), cart.getItem().getId().toString(), cart.getCount());
    }

}
