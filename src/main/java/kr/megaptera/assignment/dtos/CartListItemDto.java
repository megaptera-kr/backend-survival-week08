package kr.megaptera.assignment.dtos;

import java.util.List;

public class CartListItemDto {

    private List<ItemDto> lineItems;

    public CartListItemDto() {
    }

    public CartListItemDto(List<ItemDto> lineItems) {
        this.lineItems = lineItems;
    }

    public List<ItemDto> getLineItems() {
        return lineItems;
    }
}
