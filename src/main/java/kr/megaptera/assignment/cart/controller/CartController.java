package kr.megaptera.assignment.cart.controller;

import kr.megaptera.assignment.cart.domain.Cart;
import kr.megaptera.assignment.cart.domain.LineItemId;
import kr.megaptera.assignment.cart.dto.CartLineItemRequest;
import kr.megaptera.assignment.cart.dto.CartResponse;
import kr.megaptera.assignment.cart.dto.UpdateQuantityRequest;
import kr.megaptera.assignment.cart.service.CartService;
import kr.megaptera.assignment.product.domain.ProductId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart-line-items")
@CrossOrigin
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CartResponse getCartLineItems() {
        return cartService.listItems();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCartLineItem(@RequestBody CartLineItemRequest request) {
        ProductId productId = new ProductId(request.productId());
        cartService.addProduct(productId, request.quantity());
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCartLineItemQuantity(@PathVariable String id, @RequestBody UpdateQuantityRequest updateRequest) {
        LineItemId lineItemId = new LineItemId(id);
        cartService.changeQuantity(lineItemId,updateRequest.quantity());
    }

}
