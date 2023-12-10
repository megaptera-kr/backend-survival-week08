package kr.megaptera.assignment.dtos;

import java.util.List;


public class GetProductsOutputDto {
    public List<ProductDto> products;

    public GetProductsOutputDto(List<ProductDto> products) {
        this.products = products;
    }

}
