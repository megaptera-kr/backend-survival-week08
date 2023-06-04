package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.ProductCreateDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateProductServiceTest {
    private ProductRepository productRepository;

    private CreateProductService createProductService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        createProductService = new CreateProductService(productRepository);
    }

    @Test
    @DisplayName("상품 생성")
    void create() {
        ProductCreateDto newProduct = new ProductCreateDto("A-1", Long.valueOf(2000));

        createProductService.createProduct(newProduct);

        verify(productRepository).save(any(Product.class));
    }
}
