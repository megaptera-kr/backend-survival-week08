package kr.megaptera.assignment.dtos.request;

public class RqPostProductDto {

    private String name;

    private Long price;

    public RqPostProductDto() {
    }

    public RqPostProductDto(String name, Long price) {
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
