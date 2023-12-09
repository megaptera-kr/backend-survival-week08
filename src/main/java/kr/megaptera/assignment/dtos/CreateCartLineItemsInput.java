package kr.megaptera.assignment.dtos;

public class CreateCartLineItemsInput {
    private String productId;
    private Long quantity;

    public CreateCartLineItemsInput(String productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public Long getQuantity() {
        return quantity;
    }
}
