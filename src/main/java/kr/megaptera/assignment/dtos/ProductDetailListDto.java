package kr.megaptera.assignment.dtos;

import java.util.List;

public class ProductDetailListDto {
    private List<ProductDetailDto> products;

    protected ProductDetailListDto() {
    }

    protected ProductDetailListDto(List<ProductDetailDto> products) {
        this.products = products;
    }

    public static ProductDetailListDto of(List<ProductDetailDto> products) {
        return new ProductDetailListDto(products);
    }

    public List<ProductDetailDto> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "ProductDetailListDto{" +
               "products=" + products +
               '}';
    }
}
