package kr.megaptera.assignment.dtos;

public class UpdateCartItemDto {
    private Long quantity;

    public UpdateCartItemDto() {
    }

    public UpdateCartItemDto(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }
}
