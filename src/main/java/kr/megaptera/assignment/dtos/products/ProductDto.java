package kr.megaptera.assignment.dtos.products;

import kr.megaptera.assignment.models.Product;

import java.util.UUID;

public class ProductDto {
    UUID id;
    String name;
    Long price;

    public ProductDto(UUID id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public static ProductDto of(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }
}
