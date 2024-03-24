package dtos;

import models.CartItem;

public class CartListDto {
    private String id;
    private String productName;
    private long quantity;
    private long totalPrice;
    private long unitPrice;

    public CartListDto(String id, String productName, long quantity, long unitPrice) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = quantity * unitPrice;
    }

    public CartListDto(CartItem cartItem) {
        this.id = cartItem.product().id();
        this.productName = cartItem.product().name();
        this.quantity = cartItem.quantity();
        this.unitPrice = cartItem.product().price();
        this.totalPrice = this.unitPrice * this.quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }
}
