package kr.megaptera.assignment.dtos;

public class ProductCreateDto {
    private String name;
    private Long price;

    public ProductCreateDto() {
    }

    public ProductCreateDto(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
