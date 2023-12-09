package kr.megaptera.assignment.dtos;

import java.util.List;


public class GetProductsOutput {
    public List<ProductDto> products;

    public GetProductsOutput(List<ProductDto> products) {
        this.products = products;
    }

}
