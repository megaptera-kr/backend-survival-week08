package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Product;

public class ProductDto {
    private String id;
    private String name;
    private Long price;

    public ProductDto(Product product) {
        this.id = String.valueOf(product.id());
        this.name = product.name();
        this.price = product.price();
    }

    public ProductDto() {
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
