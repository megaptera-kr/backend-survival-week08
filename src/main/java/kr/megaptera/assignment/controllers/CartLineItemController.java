package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateCartItemService;
import kr.megaptera.assignment.applications.GetCartItemsService;
import kr.megaptera.assignment.applications.UpdateCartItemService;
import kr.megaptera.assignment.dtos.CartItemCreateDto;
import kr.megaptera.assignment.dtos.CartItemDto;
import kr.megaptera.assignment.dtos.CartItemResponseDto;
import kr.megaptera.assignment.dtos.CartItemUpdateDto;
import kr.megaptera.assignment.exceptions.CartItemNotFound;
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

import java.util.List;

@RestController
@RequestMapping("/cart-line-items")
@CrossOrigin
public class CartLineItemController {

    private final CreateCartItemService createCartItemService;
    private final GetCartItemsService getCartItemsService;
    private final UpdateCartItemService updateCartItemService;

    public CartLineItemController(CreateCartItemService createCartItemService, GetCartItemsService getCartItemsService, UpdateCartItemService updateCartItemService) {
        this.createCartItemService = createCartItemService;
        this.getCartItemsService = getCartItemsService;
        this.updateCartItemService = updateCartItemService;
    }

    @GetMapping
    public CartItemResponseDto list() {
        List<CartItemDto> cartItemDtos = getCartItemsService.getCartItemDtos();
        System.out.println("cartItemDtos : " + cartItemDtos);
        return new CartItemResponseDto(cartItemDtos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CartItemCreateDto cartItemCreateDto) {
        createCartItemService.createCartItem(cartItemCreateDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id,
                       @RequestBody CartItemUpdateDto cartItemUpdateDto) {
        updateCartItemService.updateCartItemProdudctQuantity(id, cartItemUpdateDto);
    }

    @ExceptionHandler(CartItemNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String cartItemNotFound() {
        return "해당 카트 상품을 찾을 수 없습니다.";
    }
}
