package kr.megaptera.assignment.dtos;

public class CartPostDto {
    private String productId;
    private Long quantity;

    public CartPostDto() {
    }

    public CartPostDto(String productId, Long quantity) {
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
