package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Cart;
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

    private LocalDateTime updateDateTime;

    public CartDto(Cart cart) {
        this(cart.getId().toString(), cart.getAccountId(), cart.getItem().getId().toString(),
                cart.getCount(), cart.getUpdateDateTime());
    }

}
