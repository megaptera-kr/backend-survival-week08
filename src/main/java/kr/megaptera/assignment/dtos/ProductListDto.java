package kr.megaptera.assignment.dtos;

import java.util.List;

public class ProductListDto {

    private List<ProductGetDto> products;

    public ProductListDto() {
    }

    public ProductListDto(List<ProductGetDto> products) {
        this.products = products;
    }

    public List<ProductGetDto> getProducts() {
        return products;
    }
}
