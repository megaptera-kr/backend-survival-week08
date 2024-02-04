package kr.megaptera.assignment.dtos;

public class ProductCreateDto {
    private String name;
    private Long price;

    protected ProductCreateDto() {
    }

    protected ProductCreateDto(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public static ProductCreateDto of(String name, Long price) {
        return new ProductCreateDto(name, price);
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProductCreateDto{" +
               "name='" + name + '\'' +
               ", price=" + price +
               '}';
    }
}
