package kr.megaptera.assignment.repositories;

import jakarta.annotation.PostConstruct;
import kr.megaptera.assignment.model.Cart;
import kr.megaptera.assignment.model.CartId;
import kr.megaptera.assignment.model.Product;
import kr.megaptera.assignment.model.ProductId;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartRepository {
  Map<CartId, Cart> cartIdCartMap = new HashMap<>();

  Map<ProductId, Product> productIdProductMap = new HashMap<>();

  @PostConstruct
  public void initialize() {
    Product product = Product.createProduct("우유", 4000);
    productIdProductMap.put(product.getId(), product);
    Product product1 = Product.createProduct("노트북", 2_000_000);
    productIdProductMap.put(product1.getId(), product1);
    Product product2 = Product.createProduct("서울집", 1_000_000_000);
    productIdProductMap.put(product2.getId(), product2);
  }

  public Cart createCart() {
    Cart newCart = Cart.createCart();
    cartIdCartMap.put(newCart.getId(), newCart);
    return newCart;
  }

  public Cart getCart(CartId cartId) {
    return cartIdCartMap.get(cartId);
  }

  public Cart addProduct(CartId cartId, ProductId productId) {
    Product product = productIdProductMap.get(productId);
    cartIdCartMap.get(cartId).addProductIntoCart(product);
    return cartIdCartMap.get(cartId);
  }

  public Cart deleteProduct(CartId cartId, ProductId productId) {
    Product product = productIdProductMap.get(productId);
    cartIdCartMap.get(cartId).removeProductFromCart(product);
    return cartIdCartMap.get(cartId);
  }
}
