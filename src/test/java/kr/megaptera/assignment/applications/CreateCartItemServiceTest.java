package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CartItemCreateDto;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartItemRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CreateCartItemServiceTest {
    private ProductRepository productRepository;
    private CartItemRepository cartItemRepository;

    private CreateCartItemService createCartItemService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        cartItemRepository = mock(CartItemRepository.class);
        createCartItemService = new CreateCartItemService(cartItemRepository, productRepository);
    }

    @Test
    @DisplayName("장바구니 생성")
    void create() {
        CartItemCreateDto cartItemCreateDto = new CartItemCreateDto("A-1", 2);

        Product product = new Product(ProductId.of("A-1"), "A", 1000L);


        when(productRepository.findById(ProductId.of(cartItemCreateDto.getProductId()))).thenReturn(Optional.of(product));

        createCartItemService.createCartItem(cartItemCreateDto);

        verify(productRepository).findById(ProductId.of(cartItemCreateDto.getProductId()));
        verify(cartItemRepository).save(any(CartItem.class));
    }
}
