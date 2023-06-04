package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.Product;

public class CartItemDto {
    private String id;

    private String productId;

    private String productName;

    private Product product;

    private int quantity;

    private Long totalPrice;

    private Long unitPrice;

    public CartItemDto() {
    }

    public CartItemDto(String id, Product product, int quantity, Long totalPrice, Long unitPrice) {
        this.id = id;
//        this.productId = product.id().toString();
        this.productName = product.name();
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.unitPrice = unitPrice;
    }


    public CartItemDto(String id, String productId, String productName, int quantity) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public CartItemDto(CartItem cartItem) {
        this(cartItem.id().toString(), cartItem.product(), cartItem.quantity(), cartItem.totalPrice(), cartItem.unitPrice());
    }

    public Product getProduct() {
        return product;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }
}
