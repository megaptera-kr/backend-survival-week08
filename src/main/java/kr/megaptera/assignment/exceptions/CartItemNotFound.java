package kr.megaptera.assignment.exceptions;

public class CartItemNotFound extends RuntimeException{
    public CartItemNotFound() {
        super("장바구니 상품을 찾지 못했습니다.");
    }
}
