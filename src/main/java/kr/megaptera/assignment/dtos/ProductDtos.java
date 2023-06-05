package kr.megaptera.assignment.dtos;

import java.util.List;

public class ProductDtos {
    private List<ProductDto> products;

    public ProductDtos() {
    }

    public ProductDtos(List<ProductDto> products) {
        this.products = products;
    }

    public List<ProductDto> getProducts() {
        return products;
    }
}
