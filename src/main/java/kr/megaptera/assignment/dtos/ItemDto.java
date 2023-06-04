package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.lineItems.Item;
import kr.megaptera.assignment.models.products.Product;

public class ItemDto {

    private String id;

    private String productName;

    private Long quantity;

    private Long totalPrice;

    private Long unitPrice;

    public ItemDto() {
    }

    public ItemDto(String id, String productName, Long quantity, Long totalPrice, Long unitPrice) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.unitPrice = unitPrice;
    }

    public ItemDto(Product product, long quantity) {
        this.id = product.getId().getId();
        this.productName = product.getName().getName();
        this.quantity = quantity;
        this.unitPrice = product.getPrice().getValue();
        this.totalPrice = this.unitPrice * this.quantity;
    }

    public ItemDto(Item item) {
        this.id = item.getProduct().getId().getId();
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
