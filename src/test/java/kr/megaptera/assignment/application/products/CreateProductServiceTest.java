package kr.megaptera.assignment.application.products;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.products.CreateProductDto;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@SpringBootTest
@Transactional
class CreateProductServiceTest {
    ProductRepository productRepository;

    CreateProductService createProductService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        createProductService = new CreateProductService(productRepository);
    }

    @Test
    @DisplayName("createProduct")
    void testCreateProduct() {
        String mockName = "name";
        Long price = 0L;

        CreateProductDto mockCreateProductDto = new CreateProductDto(mockName, price);

        createProductService.createProduct(mockCreateProductDto);

        verify(productRepository).save(any());
    }
}
