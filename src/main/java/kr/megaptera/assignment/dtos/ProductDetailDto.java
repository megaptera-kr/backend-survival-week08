package kr.megaptera.assignment.dtos;

public class ProductDetailDto {
    private String id;
    private String name;
    private Long price;

    protected ProductDetailDto() {
    }

    protected ProductDetailDto(String id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static ProductDetailDto of(String id, String name, Long price) {
        return new ProductDetailDto(id, name, price);
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

    @Override
    public String toString() {
        return "ProductDetailDto{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", price=" + price +
               '}';
    }
}
