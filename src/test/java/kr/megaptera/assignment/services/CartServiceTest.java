package kr.megaptera.assignment.services;

import kr.megaptera.assignment.dtos.CartResponseDto;
import kr.megaptera.assignment.model.Cart;
import kr.megaptera.assignment.model.Product;
import kr.megaptera.assignment.repositories.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {
  @Mock
  private CartRepository cartRepository;

  @InjectMocks
  private CartService cartService;

  private Cart cart;
  private Product robotProduct;


  @BeforeEach
  void setup() {
    cart = Cart.createCart();
    robotProduct = Product.createProduct("로봇", 100_000);
    Product dollProduct = Product.createProduct("인형", 100_000);

    cart.addProductIntoCart(robotProduct);
    cart.addProductIntoCart(robotProduct);
    cart.addProductIntoCart(dollProduct);
  }

  @Test
  void createCart() {
    //given
    given(cartRepository.createCart()).willReturn(cart);

    //when
    CartResponseDto cart = cartService.createCart();

    //then
    assertNotNull(cart);
    verify(cartRepository).createCart();
  }

  @Test
  void getCart() {
    //given
    given(cartRepository.getCart(any())).willReturn(cart);

    //when
    CartResponseDto cart1 = cartService.getCart(cart.getId().toString());

    //then
    assertNotNull(cart);
    verify(cartRepository).getCart(any());
    assertEquals(2, cart1.getCartItemInfos().size());

  }

  @Test
  void addProduct() {
    //given
    given(cartRepository.addProduct(any(), any())).willReturn(cart);

    //when
    CartResponseDto cart1 =
        cartService.addProduct(cart.getId().toString(), robotProduct.getId().toString());

    //then
    assertNotNull(cart);
    verify(cartRepository).addProduct(any(), any());
  }

  @Test
  void deleteProduct() {
    //given
    given(cartRepository.deleteProduct(any(), any())).willReturn(cart);

    //when
    CartResponseDto cart1 =
        cartService.deleteProduct(cart.getId().toString(), robotProduct.getId().toString());

    //then
    assertNotNull(cart);
    verify(cartRepository).deleteProduct(any(), any());
  }
}