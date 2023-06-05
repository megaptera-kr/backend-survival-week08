package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.dtos.ProductDtos;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetProductServiceTest {
    private ProductRepository productRepository;
    private GetProductService getProductService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);

        getProductService = new GetProductService(productRepository);
    }

    @Test
    void list() {
        given(productRepository.findAll()).willReturn(List.of(
            new Product(ProductId.of("1"), "상품명", 1000L)
        ));

        ProductDtos productDtos = getProductService.getProductDtos();

        assertThat(productDtos.getProducts()).hasSize(1);
        assertThat(productDtos.getProducts().get(0).getName()).isEqualTo("상품명");
    }
}
