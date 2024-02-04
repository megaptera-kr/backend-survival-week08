package kr.megaptera.assignment.dtos;

import java.util.Collections;
import java.util.List;

public class CartLineItemDetailListDto {
    private List<CartLineItemDetailDto> lineItems;

    protected CartLineItemDetailListDto() {
    }

    protected CartLineItemDetailListDto(List<CartLineItemDetailDto> lineItems) {
        this.lineItems = lineItems;
    }

    public static CartLineItemDetailListDto of(List<CartLineItemDetailDto> lineItems) {
        return new CartLineItemDetailListDto(lineItems);
    }

    public static CartLineItemDetailListDto empty() {
        return new CartLineItemDetailListDto(Collections.emptyList());
    }

    public List<CartLineItemDetailDto> getLineItems() {
        return lineItems;
    }

    @Override
    public String toString() {
        return "CartLineItemDetailListDto{" +
               "lineItems=" + lineItems +
               '}';
    }
}
