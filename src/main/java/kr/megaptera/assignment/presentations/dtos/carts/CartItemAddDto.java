package kr.megaptera.assignment.presentations.dtos.carts;

import lombok.Data;

@Data
public class CartItemAddDto {
    private String productId;
    private Long quantity;
}
