package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.AddCartItemService;
import kr.megaptera.assignment.application.GetCartItemsService;
import kr.megaptera.assignment.application.UpdateCartItemService;
import kr.megaptera.assignment.dtos.request.RqPostCartItemDto;
import kr.megaptera.assignment.dtos.request.RqUpdateCartItemDto;
import kr.megaptera.assignment.dtos.response.RpGetCartItemsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cart-line-items")
@RestController
public class CartController {

    private final GetCartItemsService getCartItemsService;
    private final AddCartItemService addCartItemService;
    private final UpdateCartItemService updateCartItemService;

    public CartController(GetCartItemsService getCartItemsService,
                          AddCartItemService addCartItemService,
                          UpdateCartItemService updateCartItemService) {
        this.getCartItemsService = getCartItemsService;
        this.addCartItemService = addCartItemService;
        this.updateCartItemService = updateCartItemService;
    }

    @GetMapping
    public RpGetCartItemsDto getCartItems() {
        return getCartItemsService.getCartItems();
    }

    @PostMapping
    public String addCartItem(@RequestBody RqPostCartItemDto dto) {
        return addCartItemService.addCartItem(dto);
    }

    @PatchMapping("/{id}")
    public String updateCartItem(@RequestBody RqUpdateCartItemDto dto,
                                 @PathVariable("id") String id) {
        return updateCartItemService.updateCartItem(dto, id);
    }
}
