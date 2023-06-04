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

    public CartDto(Cart cart) {
        this.id = cart.Id().toString();
        this.productName = cart.ProductName();
        this.quantity = cart.Quantity();
        this.totalPrice = cart.TotalPrice();
        this.unitPrice = cart.UnitPrice();
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

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }
}
