package kr.megaptera.assignment.presentations.dtos.carts;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartLineItemDto {
    private List<CartItemDto> lineItems;
}
