package application;

import dtos.CartDto;
import dtos.CartInsertDto;
import models.Cart;
import org.springframework.stereotype.Service;
import repository.CartRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<CartDto> getCartList() {
        Iterator<Cart> cartList = cartRepository.findAll().iterator();
        List<CartDto> cartDtos = new ArrayList<>();
        while (cartList.hasNext()) {
            Cart cart = cartList.next();
            cartDtos.add(new CartDto(cart));
        }
        return cartDtos;
    }

    public void insertCart(CartInsertDto cartInsertDto) {
        String itemName = cartInsertDto.getName();
        int itemQty = cartInsertDto.getQuantity();

    }
}
