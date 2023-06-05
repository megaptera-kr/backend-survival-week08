package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CreateCartItemDto;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartItemRepository;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateCartServiceTest {
    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private CreateCartService createCartService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        cartRepository = mock(CartRepository.class);
        cartItemRepository = mock(CartItemRepository.class);

        createCartService = new CreateCartService(productRepository, cartRepository, cartItemRepository);
    }

    @Test
    void createCartItem() {
        Product product = new Product(ProductId.of("1"), "상품명", 5000L);
        given(productRepository.findById(any())).willReturn(Optional.of(product));

        CreateCartItemDto createCartItemDto = new CreateCartItemDto("1", 1L);
        createCartService.createCartItem(createCartItemDto);

        verify(cartItemRepository).save(any(CartItem.class));
    }
}
