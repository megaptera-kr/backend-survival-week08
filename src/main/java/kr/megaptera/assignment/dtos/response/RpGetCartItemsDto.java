package kr.megaptera.assignment.dtos.response;

import kr.megaptera.assignment.dtos.CartDto;

import java.util.ArrayList;
import java.util.List;

public class RpGetCartItemsDto {

    private List<CartDto> lineItems = new ArrayList<>();

    public RpGetCartItemsDto() {
    }

    public RpGetCartItemsDto(List<CartDto> lineItems) {
        this.lineItems = lineItems;
    }

    public List<CartDto> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<CartDto> lineItems) {
        this.lineItems = lineItems;
    }
}
