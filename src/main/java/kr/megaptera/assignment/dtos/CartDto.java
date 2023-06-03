package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Cart;

public class CartDto {
    private String id;
    private String productName;
    private Long quantity;
    private Long totalPrice;
    private Long unitPrice;

    public CartDto() {
    }

    public CartDto(String id, String productName, Long quantity, Long unitPrice) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = unitPrice * quantity;
        this.unitPrice = unitPrice;
    }

    public CartDto(Cart cart) {
        this(cart.id().toString(), cart.name().toString(), cart.quantity(), Long.parseLong(cart.unitPrice().toString()));
    }

    public CartDto(long quantity) {
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "CartDto{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
