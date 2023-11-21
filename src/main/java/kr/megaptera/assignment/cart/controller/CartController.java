package kr.megaptera.assignment.product.controller;

import kr.megaptera.assignment.cart.dto.CartLineItemRequest;
import kr.megaptera.assignment.cart.dto.CartResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart-line-items")
@CrossOrigin
public class CartController {
    // 장바구니 조회
    @GetMapping
    public ResponseEntity<?> getCartLineItems() {
        // 장바구니 조회 로직 구현
        // 예시로 빈 목록 반환
        return ResponseEntity.ok().body(new CartResponse());
    }

    // 장바구니 생성
    @PostMapping
    public ResponseEntity<?> addCartLineItem(@RequestBody CartLineItemRequest newItem) {
        // 장바구니 추가 로직 구현
        // 장바구니 항목 추가 후 상태 코드 201 반환
        return ResponseEntity.status(201).build();
    }

    // 장바구니 상품 수량 변경
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCartLineItemQuantity(@PathVariable String id, @RequestBody UpdateQuantityRequest updateRequest) {
        // 수량 변경 로직 구현
        // 수량 변경 후 상태 코드 204 반환
        return ResponseEntity.status(204).build();
    }

}
