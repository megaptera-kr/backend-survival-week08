package kr.megaptera.assignment.dtos;

import java.util.List;

public class CartItemDtos {
    private List<CartItemDto> lineItems;

    public CartItemDtos() {
    }

    public CartItemDtos(List<CartItemDto> lineItems) {
        this.lineItems = lineItems;
    }

    public List<CartItemDto> getLineItems() {
        return lineItems;
    }
}
