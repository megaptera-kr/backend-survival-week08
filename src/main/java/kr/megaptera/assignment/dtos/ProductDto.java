package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.*;

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
        this(product.getId(), product.getName(), product.getPrice());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
