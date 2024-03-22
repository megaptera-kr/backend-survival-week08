package dtos;

public class CartUpdateDto {
    private String id;
    private long quantity;

    public CartUpdateDto() {
    }

    public CartUpdateDto(String id, long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
