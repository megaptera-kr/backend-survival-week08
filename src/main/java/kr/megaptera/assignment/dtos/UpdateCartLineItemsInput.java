package kr.megaptera.assignment.dtos;

public class UpdateCartLineItemsInput {
    private Long quantity;

    public UpdateCartLineItemsInput() {
    }

    public UpdateCartLineItemsInput(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }
}
