package kr.megaptera.assignment.cart.dto;

import kr.megaptera.assignment.cart.domain.CartId;
import kr.megaptera.assignment.cart.domain.LineItem;
import kr.megaptera.assignment.product.domain.Product;

import java.util.List;

public record CartResponse(List<LineItemResponse> lineItems) {
}
