package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.dtos.CartResponseDto;
import kr.megaptera.assignment.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
  private final CartService cartService;

  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/carts")
  public CartResponseDto createCart() {
    return cartService.createCart();
  }

  @GetMapping("/carts/{cartId}")
  public CartResponseDto getCart(@PathVariable String cartId) {
    return cartService.getCart(cartId);
  }

  @PostMapping("/carts/{cartId}/cart-items/{productId}")
  public CartResponseDto addProduct(@PathVariable String cartId, @PathVariable String productId) {
    return cartService.addProduct(cartId, productId);
  }

  @DeleteMapping("/carts/{cartId}/cart-items/{productId}")
  public CartResponseDto deleteProduct(@PathVariable String cartId,
                                       @PathVariable String productId) {
    return cartService.deleteProduct(cartId, productId);
  }

}
