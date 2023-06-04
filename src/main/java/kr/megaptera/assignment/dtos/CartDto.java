package kr.megaptera.assignment.dtos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CartDto {
    private String id;
    private List<CartItem> cartItems = new ArrayList<>();

    public CartDto() {
    }

    public CartDto(String id, List<CartItem> cartItems) {
        this.id = id;
        this.cartItems = cartItems;
    }

    public String getId() {
        return id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
