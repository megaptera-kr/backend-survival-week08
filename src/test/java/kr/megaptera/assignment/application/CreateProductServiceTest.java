package kr.megaptera.assignment.application;

import kr.megaptera.assignment.models.Money;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateProductServiceTest {
    private ProductRepository productRepository;

    private CreateProductService createProductService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);

        createProductService = new CreateProductService(productRepository);
    }

    @Test
    void createProduct() {
        String name = "제-품";
        Money price = new Money(100_000L);

        Product product = createProductService.createProduct(name, price);

        assertThat(product.name()).isEqualTo(name);
        assertThat(product.price()).isEqualTo(price);

        verify(productRepository).save(product);
    }
}
