package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Product;

public class ProductDto {
    private String id;

    private String name;

    private Long price;

    public ProductDto() {
    }

    public ProductDto(String id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDto(Product product) {
        this(product.productId().getValue(), product.name(), product.price());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }
}
