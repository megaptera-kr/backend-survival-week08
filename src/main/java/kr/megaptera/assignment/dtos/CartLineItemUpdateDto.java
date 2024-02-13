package kr.megaptera.assignment.dtos;

public class CartLineItemUpdateDto {
    private Long quantity;

    protected CartLineItemUpdateDto() {
    }

    protected CartLineItemUpdateDto(Long quantity) {
        this.quantity = quantity;
    }

    public static CartLineItemUpdateDto of(Long quantity) {
        return new CartLineItemUpdateDto(quantity);
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartLineItemUpdateDto{" +
               "quantity=" + quantity +
               '}';
    }
}
