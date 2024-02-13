package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateCartLineItemService;
import kr.megaptera.assignment.applications.GetCartLineItemListService;
import kr.megaptera.assignment.applications.UpdateCartLineItemService;
import kr.megaptera.assignment.dtos.CartLineItemCreateDto;
import kr.megaptera.assignment.dtos.CartLineItemDetailListDto;
import kr.megaptera.assignment.dtos.CartLineItemUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart-line-items")
public class CartLineItemController {
    private final GetCartLineItemListService getCartLineItemListService;
    private final CreateCartLineItemService createCartLineItemService;
    private final UpdateCartLineItemService updateCartLineItemService;

    public CartLineItemController(
            GetCartLineItemListService getCartLineItemListService,
            CreateCartLineItemService createCartLineItemService, UpdateCartLineItemService updateCartLineItemService
    ) {
        this.getCartLineItemListService = getCartLineItemListService;
        this.createCartLineItemService = createCartLineItemService;
        this.updateCartLineItemService = updateCartLineItemService;
    }

    @GetMapping
    public CartLineItemDetailListDto list() {
        return getCartLineItemListService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CartLineItemCreateDto dto) {
        createCartLineItemService.create(dto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id, @RequestBody CartLineItemUpdateDto dto) {
        System.out.println("dd");
        updateCartLineItemService.update(id, dto);
    }
}
