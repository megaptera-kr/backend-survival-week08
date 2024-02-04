package kr.megaptera.assignment.dtos;

import java.util.List;

public class ProductCreateListDto {
    private List<ProductCreateDto> products;

    protected ProductCreateListDto() {
    }

    protected ProductCreateListDto(List<ProductCreateDto> products) {
        this.products = products;
    }

    public static ProductCreateListDto of(List<ProductCreateDto> products) {
        return new ProductCreateListDto(products);
    }

    public List<ProductCreateDto> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "ProductCreateListDto{" +
               "products=" + products +
               '}';
    }
}
