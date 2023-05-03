package kr.megaptera.assignment.dtos;

public class LineItemCreateDto {
    private String productId;
    private Long quantity;

    public LineItemCreateDto() {
    }

    public LineItemCreateDto(String productId, Long quantity) {
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
