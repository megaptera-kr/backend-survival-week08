package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.model.Cart;
import kr.megaptera.assignment.model.CartItem;

import java.util.List;
import java.util.stream.Collectors;

public class CartResponseDto {
  private String cartId;
  private List<String> cartItemInfos;

  public CartResponseDto(String cartId, List<String> cartItemInfos) {
    this.cartId = cartId;
    this.cartItemInfos = cartItemInfos;
  }

  public static CartResponseDto of(Cart cart) {
    return new CartResponseDto(cart.getId().toString(),
        cart.getCartItemList().stream().map(CartItem::toString).collect(
            Collectors.toList()));
  }

  public String getCartId() {
    return cartId;
  }

  public List<String> getCartItemInfos() {
    return cartItemInfos;
  }
}
