package kr.megaptera.assignment.dtos;

public class CartItemUpdateDto {

    private int quantity;

    public CartItemUpdateDto() {
    }

    public CartItemUpdateDto(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
