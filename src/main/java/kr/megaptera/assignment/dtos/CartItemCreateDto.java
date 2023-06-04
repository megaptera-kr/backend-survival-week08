package kr.megaptera.assignment.dtos;

public class CartItemCreateDto {
    private String id;

    private String productId;

    private int quantity;

    public CartItemCreateDto() {
    }

    public CartItemCreateDto(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public CartItemCreateDto(String id, String productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
