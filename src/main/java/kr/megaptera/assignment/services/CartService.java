package kr.megaptera.assignment.services;

import kr.megaptera.assignment.dtos.CartResponseDto;
import kr.megaptera.assignment.model.CartId;
import kr.megaptera.assignment.model.ProductId;
import kr.megaptera.assignment.repositories.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
  private final CartRepository cartRepository;

  public CartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  public CartResponseDto createCart() {
    return CartResponseDto.of(cartRepository.createCart());
  }

  public CartResponseDto getCart(String cartId) {
    return CartResponseDto.of(cartRepository.getCart(CartId.of(cartId)));
  }

  public CartResponseDto addProduct(String cartId, String productId) {
    return CartResponseDto.of(
        cartRepository.addProduct(CartId.of(cartId), ProductId.of(productId)));
  }

  public CartResponseDto deleteProduct(String cartId, String productId) {
    return CartResponseDto.of(
        cartRepository.deleteProduct(CartId.of(cartId), ProductId.of(productId)));
  }
}
