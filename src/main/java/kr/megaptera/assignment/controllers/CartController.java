package kr.megaptera.assignment.controllers;


import kr.megaptera.assignment.application.CartService;
import kr.megaptera.assignment.dtos.CartDto;
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
    public List<CartDto> getCarts(@RequestAttribute String accountId) {
        List<CartDto> cartDtos = cartService.getCarts(accountId);
        return cartDtos;
    }

    @PostMapping("/items/{itemId}/{count}")
    @ResponseStatus(HttpStatus.CREATED)
    public CartDto addItemToCart(@RequestAttribute String accountId, @PathVariable String itemId,
                                 @PathVariable Integer count) {
        CartDto addedCartDto = cartService.addItemCoCart(accountId, itemId, count);
        return addedCartDto;
    }

    @DeleteMapping("/items/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CartDto deleteItemToCart(@RequestAttribute String accountId, @PathVariable String itemId) {
        CartDto deletedCartDto = cartService.removeCart(accountId, itemId);
        return deletedCartDto;
    }

    @PatchMapping("/{cartId}/{count}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CartDto updateItemCountToCart(@RequestAttribute String accountId, @PathVariable String cartId,
                                    @PathVariable Integer count) {
        CartDto addedCart = cartService.updateItemCoCart(cartId, accountId, count);
        return addedCart;
    }

}
