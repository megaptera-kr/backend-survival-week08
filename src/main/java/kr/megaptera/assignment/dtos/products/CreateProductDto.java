package kr.megaptera.assignment.dtos.products;

public class CreateProductDto {
    String name;
    Long price;

    public CreateProductDto(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }
}
