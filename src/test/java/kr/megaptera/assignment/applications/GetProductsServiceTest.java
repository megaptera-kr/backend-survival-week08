package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class GetProductsServiceTest {
    private ProductRepository productRepository;
    private GetProductsService getProductsService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        getProductsService = new GetProductsService(productRepository);
    }

    @Test
    @DisplayName("상품 목록 조회")
    void list() {
        given(productRepository.findAll()).willReturn(
                List.of(
                        new Product("A", Long.valueOf(2000)),
                        new Product("B", Long.valueOf(3000))
                )
        );

        List<ProductDto> productDtos = getProductsService.getProductDtos();

        assertThat(productDtos).hasSize(2);
    }
}
