package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.infrastructrue.CartDtoFetcher;
import kr.megaptera.assignment.models.CartId;
import org.springframework.stereotype.Service;

@Service
public class GetCartService {
    private final CartDtoFetcher cartDtoFetcher;

    public GetCartService(CartDtoFetcher cartDtoFetcher) {
        this.cartDtoFetcher = cartDtoFetcher;
    }

    public CartDto getCartDto() {
        return cartDtoFetcher.fetchCartDto(CartId.DEFAULT);
    }
}
