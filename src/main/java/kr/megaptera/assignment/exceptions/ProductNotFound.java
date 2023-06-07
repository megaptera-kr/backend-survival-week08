package kr.megaptera.assignment.exceptions;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound() {
        super("상품 정보를 찾을 수 없습니다.");
    }
}
