package kr.megaptera.assignment.dtos;

public class CreateCartDto {
    private String productId;
    private Long quantity;

    public CreateCartDto() {
    }

    public CreateCartDto(String productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "CreateProductDto{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
