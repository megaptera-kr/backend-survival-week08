package kr.megaptera.assignment.dtos;

public class CartUpdateDto {
    private Long quantity;

    public CartUpdateDto() {
    }

    public CartUpdateDto(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }
}
