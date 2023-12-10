package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateCartLineItemsService;
import kr.megaptera.assignment.applications.GetCartLineItemsService;
import kr.megaptera.assignment.applications.UpdateCartLineItemsService;
import kr.megaptera.assignment.dtos.CreateCartLineItemsInputDto;
import kr.megaptera.assignment.dtos.GetLineItemsOutputDto;
import kr.megaptera.assignment.dtos.UpdateCartLineItemsInputDto;
import kr.megaptera.assignment.exceptions.CartLineItemNotFound;
import kr.megaptera.assignment.models.CartLineItem;
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
@CrossOrigin
@RequestMapping("/cart-line-items")
public class CartLineItemsController {
    private GetCartLineItemsService getCartLineItemsService;
    private CreateCartLineItemsService createCartLineItemsService;
    private UpdateCartLineItemsService updateCartLineItemsService;

    public CartLineItemsController(GetCartLineItemsService getCartLineItemsService, CreateCartLineItemsService createCartLineItemsService, UpdateCartLineItemsService updateCartLineItemsService) {
        this.getCartLineItemsService = getCartLineItemsService;
        this.createCartLineItemsService = createCartLineItemsService;
        this.updateCartLineItemsService = updateCartLineItemsService;
    }

    @GetMapping
    public GetLineItemsOutputDto get() {
        List<CartLineItem> lineItems = getCartLineItemsService.getLineItems();
        return new GetLineItemsOutputDto(lineItems);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateCartLineItemsInputDto createCartLineItemsInputDto) {
        createCartLineItemsService.createCartLineItems(createCartLineItemsInputDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id, @RequestBody UpdateCartLineItemsInputDto updateCartLineItemsInputDto) {
        updateCartLineItemsService.updateQuantity(id, updateCartLineItemsInputDto);
    }
    
    @ExceptionHandler(CartLineItemNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String CartLineItemNotFound() {
        return "장바구니에 해당 주문이 없습니다.";
    }
}
