package kr.megaptera.assignment.dtos;

import java.util.ArrayList;
import java.util.List;

public class ProductResponseDto {
    private List<ProductDto> products;

    public ProductResponseDto(List<ProductDto> products) {
        this.products = new ArrayList<>(products);
    }

    public List<ProductDto> getProducts() {
        return products;
    }
}
