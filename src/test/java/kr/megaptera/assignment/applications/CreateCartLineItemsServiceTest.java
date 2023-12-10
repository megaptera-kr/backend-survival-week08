package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CreateCartLineItemsInputDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateCartLineItemsServiceTest {
    private ProductRepository productRepository;
    private CreateCartLineItemsService createCartLineItemsService;
    private Product product;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        createCartLineItemsService = new CreateCartLineItemsService(productRepository);
        product = mock(Product.class);
    }

    @Test
    @DisplayName("Product 엔티티 변경을 통한 장바구니 수량 업데이트")
    void createCartLineItems() {
        given(productRepository.findById(1L))
                .willReturn(Optional.of(product));
        CreateCartLineItemsInputDto createCartLineItemsInputDto = new CreateCartLineItemsInputDto("1", 5L);
        createCartLineItemsService.createCartLineItems(createCartLineItemsInputDto);
        verify(product).updateCartLineItemQuantity(any());
    }
}