package kr.megaptera.assignment.cart.dto;

import kr.megaptera.assignment.product.domain.Product;

import java.util.List;

public record CartItem (String id, List<Product> products, Long quantity, Long totalPrice, Long unitPrice) {
}
