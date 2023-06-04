package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Product;

public class ProductDto {

    private String id;

    private String name;

    private Long price;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.Id().toString();
        this.name = product.Name();
        this.price = product.Price();
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
