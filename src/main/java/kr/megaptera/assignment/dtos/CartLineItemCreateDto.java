package kr.megaptera.assignment.dtos;

public class CartLineItemCreateDto {
    private String productId;
    private Long quantity;

    protected CartLineItemCreateDto() {
    }

    protected CartLineItemCreateDto(String productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public static CartLineItemCreateDto of(String productId, Long quantity) {
        return new CartLineItemCreateDto(productId, quantity);
    }

    public String getProductId() {
        return productId;
    }

    public Long getQuantity() {
        return quantity;
    }


    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartLineItemCreateDto{" +
               "productId='" + productId + '\'' +
               ", quantity=" + quantity +
               '}';
    }
}
