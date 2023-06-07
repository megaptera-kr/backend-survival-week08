package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CreateCartService;
import kr.megaptera.assignment.application.GetCartService;
import kr.megaptera.assignment.application.UpdateCartService;
import kr.megaptera.assignment.dtos.CartListItemDto;
import kr.megaptera.assignment.dtos.CartPostDto;
import kr.megaptera.assignment.dtos.CartUpdateDto;
import kr.megaptera.assignment.exceptions.CartNotFound;
import kr.megaptera.assignment.exceptions.ItemNotFound;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cart-line-items")
@RestController
public class CartController {

    private final GetCartService getCartService;
    private final CreateCartService createCartService;
    private final UpdateCartService updateCartService;

    public CartController(GetCartService getCartService, CreateCartService createCartService, UpdateCartService updateCartService) {
        this.getCartService = getCartService;
        this.createCartService = createCartService;
        this.updateCartService = updateCartService;
    }

    @GetMapping
    public CartListItemDto getCartLineItems() {
        return getCartService.getCartLineItems();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postCartLineItem(
            @RequestBody CartPostDto cartPostDto
    ) {
        createCartService.createCartLineItem(cartPostDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchCartLineItem(
            @PathVariable String id,
            @RequestBody CartUpdateDto cartUpdateDto
    ) {
        updateCartService.updateCartLineItem(id, cartUpdateDto);
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void productNotFound() {
    }

    @ExceptionHandler(CartNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void cartNotFound() {
    }

    @ExceptionHandler(ItemNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void itemNotFound() {
    }
}
