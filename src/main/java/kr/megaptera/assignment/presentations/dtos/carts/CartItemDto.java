package kr.megaptera.assignment.presentations.dtos.carts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private String id;
    private String productName;
    private long quantity;
    private long totalPrice;
    private long unitPrice;
}
