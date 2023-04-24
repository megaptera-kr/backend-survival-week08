package kr.megaptera.assignment.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
  private CartId id;
  private List<CartItem> cartItemList;

  protected Cart(CartId id, List<CartItem> cartItemList) {
    this.id = id;
    this.cartItemList = cartItemList;
  }

  // create CartItem
  public static Cart createCart() {
    CartId cartId = CartId.generate();
    return new Cart(cartId, new ArrayList<>());
  }

  // get CartItems
  public List<CartItem> getCartItemList() {
    return cartItemList;
  }

  // add product
  public void addProductIntoCart(Product product) {
    Optional<CartItem> cartItemOptional =
        cartItemList.stream().filter(cartItem -> cartItem.getProductId().equals(product.getId()))
                    .findFirst();
    cartItemOptional.ifPresentOrElse(CartItem::increaseQuantity,
        () -> cartItemList.add(CartItem.createCartItem(product)));
  }

  // pop product
  public void removeProductFromCart(Product product) {
    Optional<CartItem> cartItemOptional =
        cartItemList.stream().filter(cartItem -> cartItem.getProductId().equals(product.getId()))
                    .findFirst();
    cartItemOptional.ifPresentOrElse(CartItem::decreaseQuantity, () -> {
      throw new IllegalArgumentException("no such product");
    });
    if (cartItemOptional.get().getQuantity().equals(new Quantity(0))) {
      cartItemList.remove(cartItemOptional.get());
    }
  }

  public CartId getId() {
    return id;
  }

  public Optional<CartItem> findCartItemByProduct(Product product) {
    Optional<CartItem> cartItemOptional =
        cartItemList.stream().filter(cartItem -> cartItem.getProductId().equals(product.getId()))
                    .findFirst();
    return cartItemOptional;
  }
}
