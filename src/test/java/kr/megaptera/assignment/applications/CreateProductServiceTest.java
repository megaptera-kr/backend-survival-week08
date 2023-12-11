package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CreateProductDto;
import kr.megaptera.assignment.models.Product;
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
    @DisplayName("관리자 상품 등록 기능 레포지터리 호출 확인")
    void create() {
        CreateProductDto createProductDto = new CreateProductDto("productName", 1000L);
        createProductService.create(createProductDto);
        verify(productRepository).save(any(Product.class));
    }

}