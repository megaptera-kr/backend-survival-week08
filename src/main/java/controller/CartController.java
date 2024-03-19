package controller;

import application.CartService;
import dtos.CartDto;
import dtos.CartInsertDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart-line-items")
@CrossOrigin
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CartDto> getCartList() {
        return cartService.getCartList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertCart(@RequestBody CartInsertDto cartInsertDto) {
        cartService.insertCart(cartInsertDto);
    }
}
