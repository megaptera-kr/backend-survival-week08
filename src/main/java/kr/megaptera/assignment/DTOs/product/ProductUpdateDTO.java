package kr.megaptera.assignment.DTOs.product;

public class ProductUpdateDTO {
    private String name;
    private Integer price;
    private String content;

    public ProductUpdateDTO() {
    }

    public ProductUpdateDTO(String name, Integer price, String content) {
        this.name = name;
        this.price = price;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }
}
