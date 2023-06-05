package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CreateProductDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
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
        CreateProductDto createProductDto = new CreateProductDto("새 상품명", 10000L);

        createProductService.createProduct(createProductDto);

        verify(productRepository).save(any(Product.class));
    }
}
