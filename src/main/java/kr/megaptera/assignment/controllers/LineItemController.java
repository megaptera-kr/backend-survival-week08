package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.cart.AddProductToCartService;
import kr.megaptera.assignment.application.cart.ChangeCartItemQuantityService;
import kr.megaptera.assignment.application.cart.GetCartService;
import kr.megaptera.assignment.dtos.AddCartLineItemDto;
import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.dtos.ChangeCartLineItemDto;
import kr.megaptera.assignment.models.LineItemId;
import kr.megaptera.assignment.models.ProductId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("cart-line-items")
@CrossOrigin
public class LineItemController {
    private final GetCartService getCartService;
    private final AddProductToCartService addProductToCartService;
    private final ChangeCartItemQuantityService changeCartItemQuantityService;

    public LineItemController(
            GetCartService getCartService,
            AddProductToCartService addProductToCartService,
            ChangeCartItemQuantityService changeCartItemQuantityService) {
        this.getCartService = getCartService;
        this.addProductToCartService = addProductToCartService;
        this.changeCartItemQuantityService = changeCartItemQuantityService;
    }

    @GetMapping
    public CartDto list() {
        return getCartService.getCartDto();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody AddCartLineItemDto dto) {
        ProductId productId = new ProductId(dto.productId());
        int quantity = dto.quantity();

        addProductToCartService.addProduct(productId, quantity);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable("id") String id,
            @RequestBody ChangeCartLineItemDto dto) {
        LineItemId lineItemId = new LineItemId(id);
        int quantity = dto.quantity();

        changeCartItemQuantityService.changeQuantity(lineItemId, quantity);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return "Not Found";
    }
}