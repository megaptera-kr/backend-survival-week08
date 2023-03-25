package kr.megaptera.assignment.DTOs;

public class CartAddDTO {
    private String productId;

    private Integer quantity;

    public CartAddDTO() {
    }

    public CartAddDTO(String productId, int quantity) {
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
