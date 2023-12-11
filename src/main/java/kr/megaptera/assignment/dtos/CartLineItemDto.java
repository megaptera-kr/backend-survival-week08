package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.CartLineItem;

public class CartLineItemDto {
    private String id;
    private String productName;
    private Long quantity;
    private Long totalPrice;
    private Long unitPrice;

    public CartLineItemDto() {
    }

    public CartLineItemDto(CartLineItem cartLineItem) {
        this.id = String.valueOf(cartLineItem.id());
        this.productName = cartLineItem.product().name();
        this.quantity = cartLineItem.quantity();
        this.totalPrice = cartLineItem.totalPrice();
        this.unitPrice = cartLineItem.unitPrice();
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
