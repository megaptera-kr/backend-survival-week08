package kr.megaptera.assignment.controllers;


import kr.megaptera.assignment.application.CartService;
import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.dtos.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping
    public List<CartDto> getCarts(@RequestAttribute String userId) {
        List<CartDto> cartDtos = cartService.getCarts(userId);
        return cartDtos;
    }

    @PostMapping("/items/{itemId}/{count}")
    @ResponseStatus(HttpStatus.CREATED)
    public CartDto addItemToCart(@RequestAttribute String userId, @PathVariable String itemId,
                                 @PathVariable Integer count) {
        CartDto addedCartDto = cartService.addItemCoCart(userId, itemId, count);
        return addedCartDto;
    }

    @DeleteMapping("/items/{itemId}")
    public CartDto deleteItemToCart(@RequestAttribute String userId, @PathVariable String itemId) {
        CartDto deletedCartDto = cartService.removeCart(userId, itemId);
        return deletedCartDto;
    }

    @PatchMapping("/{cartId}/{count}")
    @ResponseStatus(HttpStatus.CREATED)
    public CartDto updateItemCountToCart(@RequestAttribute String userId, @PathVariable String cartId,
                                    @PathVariable Integer count) {
        CartDto addedCart = cartService.updateItemCoCart(cartId, userId, count);
        return addedCart;
    }

}
