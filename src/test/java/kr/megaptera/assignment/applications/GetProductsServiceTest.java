package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetProductsServiceTest {

    private ProductRepository productRepository;
    private GetProductsService getProductsService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        getProductsService = new GetProductsService(productRepository);
    }

    @Test
    @DisplayName("상품 목록 조회")
    void getProducts() {
        given(productRepository.findAll())
                .willReturn(List.of(new Product("name", 1000L)));
        List<Product> products = getProductsService.getProducts();
        Assertions.assertThat(products.size()).isEqualTo(1);
    }
}