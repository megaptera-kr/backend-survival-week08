package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.ProductGetDto;
import kr.megaptera.assignment.models.products.Price;
import kr.megaptera.assignment.models.products.Product;
import kr.megaptera.assignment.models.products.ProductName;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        Product product = new Product(ProductName.of("랑데부"), Price.of(15000));
        Product newProduct = new Product(ProductName.of("데자부"), Price.of(13000));

        given(productRepository.findAll())
                .willReturn(List.of(product, newProduct));

        List<ProductGetDto> products = getProductsService.getProducts();

        assertThat(products.size()).isEqualTo(2);
        assertThat(products.get(0).getId()).isNotEqualTo(products.get(1).getId());
        assertThat(products.get(1).getPrice()).isEqualTo(13000);
        assertThat(products.get(0).getName()).contains("랑데");
    }
}