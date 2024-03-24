package controller;

import application.CartService;
import dtos.CartInsertDto;
import dtos.CartListDto;
import dtos.CartUpdateDto;
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
    public List<CartListDto> getCartList() {
        return cartService.getCartList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertCart(@RequestBody CartInsertDto cartInsertDto) {
        cartService.insertCartList(cartInsertDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCart(@PathVariable("id") String id, @RequestBody CartUpdateDto dto) {
        dto.setId(id);
        cartService.updateCart(dto);
    }
}
