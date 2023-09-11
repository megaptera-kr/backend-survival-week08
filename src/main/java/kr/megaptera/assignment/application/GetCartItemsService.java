package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.dtos.response.RpGetCartItemsDto;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCartItemsService {

    private final CartRepository cartRepository;

    public GetCartItemsService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public RpGetCartItemsDto getCartItems() {
        List<Cart> carts = cartRepository.findAll();
        List<CartDto> cartDtoList = carts.stream().map(CartDto::new).toList();
        return new RpGetCartItemsDto(cartDtoList);
    }
}
