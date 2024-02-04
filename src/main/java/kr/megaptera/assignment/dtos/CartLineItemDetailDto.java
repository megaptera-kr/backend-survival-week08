package kr.megaptera.assignment.dtos;

public class CartLineItemDetailDto {
    private String id;
    private String productName;
    private Long quantity;
    private Long totalPrice;
    private Long unitPrice;

    protected CartLineItemDetailDto() {
    }

    protected CartLineItemDetailDto(String id, String productName, Long quantity, Long totalPrice, Long unitPrice) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public static CartLineItemDetailDto of(String id, String productName, Long quantity, Long totalPrice, Long unitPrice) {
        return new CartLineItemDetailDto(id, productName, quantity, totalPrice, unitPrice);
    }

    @Override
    public String toString() {
        return "CartLineItemDetailDto{" +
               "id='" + id + '\'' +
               ", productName='" + productName + '\'' +
               ", quantity=" + quantity +
               ", totalPrice=" + totalPrice +
               ", unitPrice=" + unitPrice +
               '}';
    }
}
