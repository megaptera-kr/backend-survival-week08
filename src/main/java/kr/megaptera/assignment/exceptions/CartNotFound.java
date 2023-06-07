package kr.megaptera.assignment.exceptions;

public class CartNotFound extends RuntimeException {
    public CartNotFound() {
        super("장바구니를 찾을 수 없습니다.");
    }
}
