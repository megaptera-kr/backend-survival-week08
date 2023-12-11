package kr.megaptera.assignment.dtos;

public class UpdateCartLineItemsInputDto {
    private Long quantity;

    public UpdateCartLineItemsInputDto() {
    }

    public UpdateCartLineItemsInputDto(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }
}
