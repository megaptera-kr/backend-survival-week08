package kr.megaptera.assignment.DTOs.product;

public class ProductCreateDTO {
    private String type;
    private String name;
    private Integer price;
    private String content;

    public ProductCreateDTO() {
    }

    public ProductCreateDTO(String type, String name, Integer price, String content) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.content = content;
    }

    public String getType() {
        return type;
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
