package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.CartLineItem;

import java.util.List;

public class GetLineItemsOutputDto {
    public List<CartLineItemDto> lineItems;

    public GetLineItemsOutputDto(List<CartLineItem> lineItems) {
        this.lineItems = lineItems.stream().map(cartLineItem -> new CartLineItemDto(cartLineItem)).toList();
    }
}
