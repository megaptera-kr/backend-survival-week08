package kr.megaptera.assignment.application.products;

import kr.megaptera.assignment.dtos.products.ProductDto;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetListProductServiceTest {
    ProductRepository productRepository;
    GetListProductService getListProductService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        getListProductService = new GetListProductService(productRepository);
    }

    @Test
    @DisplayName("getListProduct")
    void testGetListProduct() {
        List<ProductDto> listProduct = getListProductService.getListProduct();

        verify(productRepository).findAll();
    }
}