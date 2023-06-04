package kr.megaptera.assignment.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {

    @Test
    void creation() {
        List<CartItem> cartItemList = new ArrayList<>();
        CartItem cartItem1 = new CartItem(
                Long.valueOf(1),
                new Product("A", Long.valueOf(1000)),
                2
        );
        CartItem cartItem2 = new CartItem(
                Long.valueOf(2),
                new Product("B", Long.valueOf(2000)),
                2
        );
        cartItemList.add(cartItem1);
        cartItemList.add(cartItem2);
        Cart cart = new Cart(
                cartItemList
        );
        assertThat(cart.cartItems().get(0).unitPrice()).isEqualTo(1000);
        assertThat(cart.cartItems().get(0).totalPrice()).isEqualTo(2000);

        assertThat(cart.cartItems().get(1).unitPrice()).isEqualTo(2000);
        assertThat(cart.cartItems().get(1).totalPrice()).isEqualTo(4000);
    }

    @Test
    void update() {
        List<CartItem> cartItemList = new ArrayList<>();
        Product product = new Product("A", Long.valueOf(1000));
        CartItem cartItem1 = new CartItem(
                Long.valueOf(1),
                product,
                2
        );
        cartItemList.add(cartItem1);
        Cart cart = new Cart(
                cartItemList
        );

        assertThat(cart.cartItems().get(0).unitPrice()).isEqualTo(1000);
        assertThat(cart.cartItems().get(0).totalPrice()).isEqualTo(2000);

        cart.updateItemQuantity(product, 3);

        assertThat(cart.cartItems().get(0).unitPrice()).isEqualTo(1000);
        assertThat(cart.cartItems().get(0).totalPrice()).isEqualTo(3000);
    }
}
