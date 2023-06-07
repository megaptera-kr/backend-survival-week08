package kr.megaptera.assignment.exceptions;

public class ItemNotFound extends RuntimeException {
    public ItemNotFound() {
        super("장바구니에 추가한 상품을 찾을 수 없습니다.");
    }
}
