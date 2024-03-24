package models;

import java.util.List;

public class CartList {
    private List<CartItem> cartItemList;
    private long totalPrice;
    private long totalQuantity;

    public CartList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
        this.totalPrice = cartItemList.stream()
                .mapToLong(cartItem -> cartItem.product().price() * cartItem.quantity())
                .sum();
        this.totalQuantity = cartItemList.stream()
                .mapToLong(cartItem -> cartItem.quantity())
                .sum();
    }
}
