package kr.megaptera.assignment.dtos;

public class CreateProductDto {
    private String name;
    private Long price;

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public CreateProductDto(String name, Long price) {
        this.name = name;
        this.price = price;
    }
}
