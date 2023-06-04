package kr.megaptera.assignment.dtos;

public class ProductPostDto {

    private String name;

    private Long price;

    public ProductPostDto() {
    }

    public ProductPostDto(String name, Long price) {
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
