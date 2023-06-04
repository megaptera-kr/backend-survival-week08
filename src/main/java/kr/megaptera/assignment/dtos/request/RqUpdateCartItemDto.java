package kr.megaptera.assignment.dtos.request;

public class RqUpdateCartItemDto {

    private Long quantity;

    public RqUpdateCartItemDto() {
    }

    public RqUpdateCartItemDto(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
