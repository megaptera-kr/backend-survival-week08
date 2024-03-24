package kr.megaptera.assignment.application.product;

import kr.megaptera.assignment.dtos.ProductListDto;
import kr.megaptera.assignment.infrastructure.ProductDtoFetcher;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GetProductListServiceTest {
    private ProductDtoFetcher productDtoFetcher;
    private GetProductListService getProductListService;

    @BeforeEach
    void setUp() {
        productDtoFetcher = mock(ProductDtoFetcher.class);

        getProductListService = new GetProductListService(productDtoFetcher);
    }

    @Test
    void getProductList() {
        getProductListService.getProductListDto();

        verify(productDtoFetcher).fetchProductListDto();
    }
}
