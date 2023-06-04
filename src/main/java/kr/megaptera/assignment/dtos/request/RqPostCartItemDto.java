package kr.megaptera.assignment.dtos.request;

public class RqPostCartItemDto {

    private String productId;

    private Long quantity;

    public RqPostCartItemDto() {
    }

    public RqPostCartItemDto(String productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
