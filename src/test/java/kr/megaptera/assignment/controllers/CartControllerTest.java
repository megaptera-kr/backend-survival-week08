package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.dtos.CartResponseDto;
import kr.megaptera.assignment.model.Cart;
import kr.megaptera.assignment.model.Product;
import kr.megaptera.assignment.services.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartController.class)
class CartControllerTest {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  private CartService cartService;

  private CartResponseDto cartResponseDto;


  @BeforeEach
  void setUp() {
    Cart cart = Cart.createCart();
    Product robotProduct = Product.createProduct("로봇", 100_000);
    Product dollProduct = Product.createProduct("인형", 100_000);
    cart.addProductIntoCart(robotProduct);
    cart.addProductIntoCart(robotProduct);
    cart.addProductIntoCart(dollProduct);
    this.cartResponseDto = CartResponseDto.of(cart);
  }

  @Test
  @DisplayName("POST /carts")
  void creatCart() throws Exception {
    given(cartService.createCart()).willReturn(CartResponseDto.of(Cart.createCart()));

    mockMvc.perform(post("/carts"))
           .andExpect(status().isCreated())
           .andExpect(content().string(containsString("cartId")));
  }

  @Test
  @DisplayName("GET /carts/{cartId}")
  void getCart() throws Exception {
    given(cartService.getCart(any())).willReturn(cartResponseDto);

    mockMvc.perform(get("/carts/1"))
           .andExpect(status().isOk())
           .andExpect(content().string(containsString("CartItem")));
  }

  @Test
  void addProduct() throws Exception {
    given(cartService.addProduct(any(), any())).willReturn(cartResponseDto);
    mockMvc.perform(post("/carts/1/cart-items/2"))
           .andExpect(status().isOk())
           .andExpect(content().string(containsString("CartItem")));
  }

  @Test
  void deleteProduct() throws Exception {
    given(cartService.deleteProduct(any(), any())).willReturn(cartResponseDto);
    mockMvc.perform(delete("/carts/1/cart-items/2"))
           .andExpect(status().isOk())
           .andExpect(content().string(containsString("CartItem")));
  }
}