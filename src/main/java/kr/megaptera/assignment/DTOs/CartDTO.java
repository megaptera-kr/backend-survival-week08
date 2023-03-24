package kr.megaptera.assignment.DTOs;

public class CartDTO {
    private String productId;

    private Integer quantity;

    public CartDTO() {
    }

    public CartDTO(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
