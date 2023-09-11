package kr.megaptera.assignment.dtos.response;

import kr.megaptera.assignment.dtos.ProductDto;

import java.util.List;

public class RpGetProductsDto {

    private List<ProductDto> products;


    public RpGetProductsDto() {
    }

    public RpGetProductsDto(List<ProductDto> products) {
        this.products = products;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
