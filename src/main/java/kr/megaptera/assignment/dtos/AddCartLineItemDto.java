package kr.megaptera.assignment.dtos;

public record AddCartLineItemDto(
        String productId,
        int quantity
) {
}
