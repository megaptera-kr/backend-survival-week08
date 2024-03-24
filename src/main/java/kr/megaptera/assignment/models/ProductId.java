package kr.megaptera.assignment.models;

public class ProductId extends EntityId {
    public ProductId() {
        super();
    }
    public ProductId(String value) {
        super(value);
    }

    public static ProductId generate() {
        return new ProductId(newTsid());
    }
}
