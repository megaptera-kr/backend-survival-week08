package kr.megaptera.assignment.cart.dto;

public record LineItemResponse(String id, String productName, int quantity, long unitPrice, long totalPrice) {
}
