package kr.megaptera.assignment.DTOs.product;

import kr.megaptera.assignment.Models.product.*;

public class ProductDTO {
    private String productId;
    private String userId;
    private String type;
    private String name;
    private Integer price;
    private Integer quantity;
    private String content;

    public ProductDTO() {
    }

    public ProductDTO(String productId, String type, String name, Integer price, String content) {
        this.productId = productId;
        this.type = type;
        this.name = name;
        this.price = price;
        this.content = content;
    }

    public ProductDTO(String productId, String userId, String type, String name, Integer price, Integer quantity, String content) {
        this.productId = productId;
        this.userId = userId;
        this.type = type;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.content = content;
    }

    public ProductDTO(Product product) {
        this(
                product.id().toString(),
                product.type().toString(),
                product.name(),
                product.price(),
                product.content().toString());
    }

    public String getProductId() {
        return productId;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
