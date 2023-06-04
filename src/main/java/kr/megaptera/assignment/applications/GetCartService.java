package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.infrastructure.CartDtoFetcher;
import kr.megaptera.assignment.models.CartId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetCartService {
    private final CartDtoFetcher cartDtoFetcher;

    public GetCartService(CartDtoFetcher cartDtoFetcher) {
        this.cartDtoFetcher = cartDtoFetcher;
    }

    public CartDto getCartDto() {
        return cartDtoFetcher.fetchCartDto(CartId.DEFAULT);
    }
}
