package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.UpdateCartLineItemsInputDto;
import kr.megaptera.assignment.exceptions.CartLineItemNotFound;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class UpdateCartLineItemsServiceTest {

    private ProductRepository productRepository;
    private UpdateCartLineItemsService updateCartLineItemService;
    private Long PRODUCT_ID = 1L;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        updateCartLineItemService = new UpdateCartLineItemsService(productRepository);
    }

    @Test
    @DisplayName("장바구니 없는 상품 수량 업데이트시 에러 발생")
    void updateQuantity() {
        Product product = new Product("productName", 1000L);
        given(productRepository.findById(PRODUCT_ID))
                .willReturn(Optional.of(product));
        UpdateCartLineItemsInputDto updateCartLineItemsInputDto = new UpdateCartLineItemsInputDto(5L);

        assertThrows(CartLineItemNotFound.class, () -> {
            updateCartLineItemService.updateQuantity(String.valueOf(PRODUCT_ID), updateCartLineItemsInputDto);
        });
    }
}