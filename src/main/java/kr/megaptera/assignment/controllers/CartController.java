package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CartService;
import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.dtos.CreateCartDto;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart-line-items")
@CrossOrigin("*")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public Map<String, List<CartDto>> getCartList() {
        Map<String, List<CartDto>> carts = new HashMap<String, List<CartDto>>();
        carts.put("lineItems", cartService.getCartLists());
        return carts;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCart(
            @RequestBody CreateCartDto cartDto
    ) {
        cartService.createCart(cartDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateQuantity(
            @PathVariable String id,
            @RequestBody CartDto cartDto
    ) {
        //System.out.println("cartDto : " + cartDto);
        //System.out.println("id : " + id);
        cartService.updateQuantity(cartDto, id);
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String ProductNotFound() {
        return "카트에 추가하려는 상품을 찾을 수 없습니다.";
    }
}
