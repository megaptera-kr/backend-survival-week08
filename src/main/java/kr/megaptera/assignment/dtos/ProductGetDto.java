package kr.megaptera.assignment.dtos;

public class ProductGetDto {

    private String id;

    private String name;

    private Long price;

    public ProductGetDto() {
    }

    public ProductGetDto(String id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }
}
