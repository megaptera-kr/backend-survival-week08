package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.CartItem;

public class CartItemDto {
    private String id;
    private String productName;
    private Long quantity;
    private Long totalPrice;
    private Long unitPrice;

    public CartItemDto() {
    }

    public CartItemDto(String id, String productName, Long quantity, Long totalPrice, Long unitPrice) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.unitPrice = unitPrice;
    }

    public CartItemDto(CartItem cartItem) {
        this.id = cartItem.cartItemId().toString();
        this.productName = cartItem.product().name();
        this.quantity = cartItem.qantity();
        this.totalPrice = cartItem.totalPrice();
        this.unitPrice = cartItem.unitPrice();
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
}
