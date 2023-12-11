package kr.megaptera.assignment.dtos;

public class CreateCartLineItemsInputDto {
    private String productId;
    private Long quantity;

    public CreateCartLineItemsInputDto(String productId, Long quantity) {
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
