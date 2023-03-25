package kr.megaptera.assignment.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CartTest {
  Cart cart;

  @BeforeEach
  void setUp() {
    cart = Cart.createCart();
  }

  @Test
  void createCart() {
    // given

    // when
    Cart newCart = Cart.createCart();

    // then
    Assertions.assertNotNull(newCart);
    Assertions.assertNotNull(newCart.getId());
  }

  @Test
  void getCartItemList() {
    // given
    Cart newCart = Cart.createCart();

    // when
    List<CartItem> cartItemList = newCart.getCartItemList();

    // then
    Assertions.assertNotNull(cartItemList);
    Assertions.assertEquals(0, cartItemList.size());
  }

  @Test
  void addProductIntoCart() {
    //given
    Product robotProduct = Product.createProduct("로봇", 100_000);

    //when
    cart.addProductIntoCart(robotProduct);

    //then
    Assertions.assertEquals(cart.getCartItemList().get(0).getProductId(), robotProduct.getId());

  }

  @Test
  void addProductsIntoCart() {
    //given
    Product robotProduct = Product.createProduct("로봇", 100_000);
    Product dollProduct = Product.createProduct("인형", 100_000);

    //when
    cart.addProductIntoCart(robotProduct);
    cart.addProductIntoCart(robotProduct);
    cart.addProductIntoCart(dollProduct);

    //then
    Assertions.assertEquals(new Quantity(2),
        cart.findCartItemByProduct(robotProduct).get().getQuantity());
    Assertions.assertEquals(new Quantity(1),
        cart.findCartItemByProduct(dollProduct).get().getQuantity());

  }

  @Test
  void removeProductFromCartOnlyDecrease() {
    //given
    Product robotProduct = Product.createProduct("로봇", 100_000);
    Product dollProduct = Product.createProduct("인형", 100_000);
    cart.addProductIntoCart(robotProduct);
    cart.addProductIntoCart(robotProduct);
    cart.addProductIntoCart(dollProduct);

    //when
    cart.removeProductFromCart(robotProduct);

    //then
    Assertions.assertEquals(new Quantity(1),
        cart.findCartItemByProduct(robotProduct).get().getQuantity());

  }

  @Test
  void removeProductFromCartAndRemoveCartItem() {
    //given
    Product robotProduct = Product.createProduct("로봇", 100_000);
    Product dollProduct = Product.createProduct("인형", 100_000);
    cart.addProductIntoCart(robotProduct);
    cart.addProductIntoCart(robotProduct);
    cart.addProductIntoCart(dollProduct);

    //when
    cart.removeProductFromCart(dollProduct);

    //then
    Assertions.assertTrue(cart.findCartItemByProduct(dollProduct).isEmpty());

  }
}