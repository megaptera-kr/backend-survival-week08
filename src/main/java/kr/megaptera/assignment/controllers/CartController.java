package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.DTOs.*;
import kr.megaptera.assignment.DTOs.product.*;
import kr.megaptera.assignment.application.cart.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {
    private final GetProductsInCartService getProductsInCartService;
    private final AddProductInCartService addProductInCartService;
    private final RemoveProductIncartService removeProductIncartService;

    public CartController(GetProductsInCartService getProductsInCartService,
                          AddProductInCartService addProductInCartService,
                          RemoveProductIncartService removeProductIncartService) {
        this.getProductsInCartService = getProductsInCartService;
        this.addProductInCartService = addProductInCartService;
        this.removeProductIncartService = removeProductIncartService;
    }

    @GetMapping
    public List<ProductDTO> list() {
        // 세션에 저장되어있을 아이디 임의로 지정
        String userId = "jyh";

        List<ProductDTO> itemInCart = getProductsInCartService.getItemInCart(userId);
        return itemInCart;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addProduct(
            @RequestBody CartAddDTO cartAddDTO
    ) {
        // 세션에 저장되어있을 아이디 임의로 지정
        String userId = "jyh";
        addProductInCartService.addProduct(userId, cartAddDTO);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(
            @PathVariable String productId
    ) {
        // 세션에 저장되어있을 아이디 임의로 지정
        String userId = "jyh";

    }
}
