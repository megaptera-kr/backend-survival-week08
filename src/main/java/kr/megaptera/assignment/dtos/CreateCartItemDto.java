package kr.megaptera.assignment.dtos;

public class CreateCartItemDto {
    private String productId;

    private Long quantity;

    public CreateCartItemDto() {
    }

    public CreateCartItemDto(String productId, Long quantity) {
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
