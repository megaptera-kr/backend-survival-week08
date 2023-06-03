package kr.megaptera.assignment.exceptions;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound() {
        super("상품을 찾지 못했습니다.");
    }
}
