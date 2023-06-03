package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateCartService;
import kr.megaptera.assignment.applications.GetCartService;
import kr.megaptera.assignment.applications.UpdateCartService;
import kr.megaptera.assignment.dtos.CartItemDtos;
import kr.megaptera.assignment.dtos.CreateCartItemDto;
import kr.megaptera.assignment.dtos.UpdateCartItemDto;
import kr.megaptera.assignment.exceptions.CartItemNotFound;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart-line-items")
@CrossOrigin
public class CartController {
    private final GetCartService getCartService;
    private final CreateCartService createCartService;
    private final UpdateCartService updateCartService;

    public CartController(GetCartService getCartService,
                          CreateCartService createCartService,
                          UpdateCartService updateCartService) {
        this.getCartService = getCartService;
        this.createCartService = createCartService;
        this.updateCartService = updateCartService;
    }

    @GetMapping
    private CartItemDtos list() {
        return getCartService.getCartItemDtos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void createCartItem(@RequestBody CreateCartItemDto createCartItemDto) {
        createCartService.createCartItem(createCartItemDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void updateCartItem(
        @PathVariable String id,
        @RequestBody UpdateCartItemDto updateCartItemDto) {
        updateCartService.updateCartItem(id, updateCartItemDto);
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ProductNotFound productNotFound() {
        return new ProductNotFound();
    }

    @ExceptionHandler(CartItemNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private CartItemNotFound cartItemNotFound() {
        return new CartItemNotFound();
    }
}
