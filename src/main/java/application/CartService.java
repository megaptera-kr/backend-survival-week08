package application;

import dtos.CartInsertDto;
import dtos.CartListDto;
import dtos.CartUpdateDto;
import models.CartItem;
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

    public List<CartListDto> getCartList() {
        Iterator<CartItem> cartList = cartRepository.findAll().iterator();
        List<CartListDto> cartListDtos = new ArrayList<>();
        while (cartList.hasNext()) {
            CartItem cartItem = cartList.next();
            cartListDtos.add(new CartListDto(cartItem));
        }
        return cartListDtos;
    }

    public void insertCartList(CartInsertDto cartInsertDto) {
        CartItem cartItem = new CartItem(cartInsertDto);
        cartRepository.save(cartItem);
    }

    public void updateCart(CartUpdateDto dto) {
        CartItem cartItem = new CartItem(dto);
        cartRepository.save(cartItem);
    }
}
