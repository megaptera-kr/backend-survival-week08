package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.*;

public class LineItemDto {

    private String id;
    private String productName;
    private Long quantity;
    private Long totalPrice;
    private Long unitPrice;

    public LineItemDto() {
    }

    public LineItemDto(String id, String productName, Long quantity, Long totalPrice, Long unitPrice) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.unitPrice = unitPrice;
    }

    public LineItemDto(LineItem lineItem) {
    this(lineItem.getId(), lineItem.getProductName(),
            lineItem.getQuantity(), lineItem.getTotalPrice(), lineItem.getUnitPrice());

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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }
}
