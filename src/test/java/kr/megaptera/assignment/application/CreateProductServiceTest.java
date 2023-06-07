package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.ProductCreateDto;
import kr.megaptera.assignment.models.products.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("상품 추가하기")
    void addProduct() {
        ProductCreateDto dto = new ProductCreateDto("랑데부", 15000L);
        createProductService.createProduct(dto);

        verify(productRepository).save(any(Product.class));
    }
}